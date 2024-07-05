import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.customexceptions.InvalidObjectMapperDetailsException;
import com.everstage.juiceshop.pojo.LoginInputBuilder;
import com.everstage.juiceshop.utils.DynamicXpath;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class BasicTest {

    @Test
    public void Test() throws InterruptedException {

        // Reading input from new-user.json using jackson-databind library
        ObjectMapper objectMapper=new ObjectMapper();
        LoginInputBuilder userCredentials= null;
        try {
            userCredentials = objectMapper.readValue(new File(FrameworkConstants.getLOGIN_JSON_PATH()), LoginInputBuilder.class);
        } catch (IOException e) {
            throw new InvalidObjectMapperDetailsException("Verify json file path and Class file");
        }

        WebDriver driver=new ChromeDriver();
        driver.get(FrameworkConstants.getWEB_LOGIN_URL());
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(FrameworkConstants.getEXP_TIME_WAIT()));

        // Sweet Alert
        String btnDismiss = DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(), "Dismiss");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDismiss))).click();

        // Login entry
        driver.findElement(By.xpath(Locators.getLOGIN_EMAIL())).sendKeys(userCredentials.getEmail());
        driver.findElement(By.xpath(Locators.getLOGIN_PASSWORD())).sendKeys(userCredentials.getPassword());
        driver.findElement(By.xpath(Locators.getLOGIN_BUTTON())).click();
        driver.findElement(By.xpath(Locators.getBUTTON_ME_WANT_IT())).click();

        // Product Selection
        String desiredProduct = DynamicXpath.getDesiredXpath(Locators.getBASE_PRODUCT(),userCredentials.getProduct());
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desiredProduct)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        String btnYourBasket = DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Your Basket");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnYourBasket)))).click();

        // Checkout Page
        ((JavascriptExecutor) driver).executeScript("location.reload()");
        String btnCheckOut=DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Checkout");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnCheckOut))))
                .click();

        // Address selection
        List<WebElement> rows =driver.findElements(By.xpath(Locators.getTABLE_ROW()));
        List<WebElement> columns =driver.findElements(By.xpath(Locators.getTABLE_COLUMN()));

        outerLoop:for (WebElement row: rows) {
                        for (WebElement column: columns) {
                            if(column.getText().equalsIgnoreCase(userCredentials.getNameForAddressSelection())){
                                    column.click();
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                break outerLoop;
                }
            }
        }
        String btnContinueAddress=DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Continue");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnContinueAddress)))).click();

        // Delivery selection
        List<WebElement> rowsDel =driver.findElements(By.xpath(Locators.getTABLE_ROW()));
        List<WebElement> columnsDel =driver.findElements(By.xpath(Locators.getTABLE_ROW()));

        outerLoop:for (WebElement row: rowsDel) {
            for (WebElement column: columnsDel) {
                if(column.getText().contains(userCredentials.getDeliveryType())){
                    column.click();
                    Thread.sleep(3000);
                    break outerLoop;
                }
            }
        }
        String btnContinueDelivery=DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Continue");
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(btnContinueDelivery)))).click();

        // Card selection
        List<WebElement> rowsPay =driver.findElements(By.xpath(Locators.getTABLE_ROW()));
        List<WebElement> columnsPay =driver.findElements(By.xpath(Locators.getTABLE_ROW()));
        outerLoop:for (WebElement row: rowsPay) {
            for (WebElement column: columnsPay) {
                if(column.getText().contains(userCredentials.getCardHolderNameForCardSelection())){
                    String desiredXpath=DynamicXpath.
                            getDesiredXpath(Locators.getBASE_RADIO(),userCredentials.getCardHolderNameForCardSelection());
                    wait.until(ExpectedConditions
                            .elementToBeClickable(driver.findElement(By.xpath(desiredXpath)))).click();
                    Thread.sleep(3000);
                    break outerLoop;
                }
            }
        }
        String btnContinueCardDetails=DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Continue");
        wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath(btnContinueCardDetails)))).click();

        // Place Order Page
        String btnPlaceYourOrderAndPay=DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Place your order and pay");
        wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath(btnPlaceYourOrderAndPay)))).click();

        //Assertion
        JavascriptExecutor js=((JavascriptExecutor) driver);
        List<WebElement> elements = (List<WebElement>) js.executeScript(
                "return document.getElementsByClassName('confirmation');"
        );

        for (WebElement element:
             elements) {
            boolean isConfirmationHeaderDisplayed =  element.isDisplayed();
            Assert.assertTrue(isConfirmationHeaderDisplayed,"Assertion Failed");
        }

    }
}
