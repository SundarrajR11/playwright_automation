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
        ClickButtonAfterWait.waitAndClick(driver,wait,"Your Basket");

        // Checkout Page
        ((JavascriptExecutor) driver).executeScript("location.reload()");
        ClickButtonAfterWait.waitAndClick(driver,wait,"Checkout");


        // Address selection
        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,userCredentials.getNameForAddressSelection());
        ClickButtonAfterWait.waitAndClick(driver,wait,"Continue");


        // Delivery selection
        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,userCredentials.getDeliveryType());
        ClickButtonAfterWait.waitAndClick(driver,wait,"Continue");

        // Card selection

        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,userCredentials.getCardHolderNameForCardSelection());
        ClickButtonAfterWait.waitAndClick(driver,wait,"Continue");

        // Place Order Page

        ClickButtonAfterWait.waitAndClick(driver,wait,"Place your order and pay");

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
