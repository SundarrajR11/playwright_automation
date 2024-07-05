import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.pojo.LoginInputBuilder;
import com.everstage.juiceshop.utils.DynamicXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BasicTest {

    @Test
    public void Test() throws InterruptedException {

        LoginInputBuilder userCredentials=LoginInputBuilder.builder()
                 .setEmail("ragusundar935@gmail.com")
                 .setPassword("SunJuice@11")
                 .build();

        WebDriver driver=new ChromeDriver();
        driver.get(FrameworkConstants.getWEB_LOGIN_URL());
        driver.manage().window().maximize();

        // Sweet Alert
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(FrameworkConstants.getEXP_TIME_WAIT()));
        String btnDismiss = DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(), "Dismiss");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnDismiss))).click();

        // Login entry
        driver.findElement(By.xpath(Locators.getLOGIN_EMAIL())).sendKeys(userCredentials.getEmail());
        driver.findElement(By.xpath(Locators.getLOGIN_PASSWORD())).sendKeys(userCredentials.getPassword());
        driver.findElement(By.xpath(Locators.getLOGIN_BUTTON())).click();
        driver.findElement(By.xpath(Locators.getBUTTON_ME_WANT_IT())).click();


        // Product selection
        String desiredProduct = DynamicXpath.getDesiredXpath(Locators.getBASE_PRODUCT(), "Banana Juice (1000ml)");
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desiredProduct)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        String btnYourBasket = DynamicXpath.getDesiredXpath(Locators.getBASE_BUTTON(),"Your Basket");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(btnYourBasket))))
                .click();

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
                            if(column.getText().equalsIgnoreCase("Name")){
                                    column.click();
                                    Thread.sleep(3000);
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
                if(column.getText().contains("Fast Delivery")){
                    System.out.println(column.getText());
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
        String name="HDFC";
        outerLoop:for (WebElement row: rowsPay) {
            for (WebElement column: columnsPay) {
                if(column.getText().contains(name)){
                    System.out.println(column.getText());
                    String desiredXpath=DynamicXpath.
                            getDesiredXpath(Locators.getBASE_RADIO(),name);
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
