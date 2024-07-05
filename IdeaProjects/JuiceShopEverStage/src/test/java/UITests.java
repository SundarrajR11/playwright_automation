import com.everstage.juiceshop.utils.DynamicXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UITests extends BasicTest{
    @Test
    public void Test() {

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
        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,wait,userCredentials.getNameForAddressSelection());
        ClickButtonAfterWait.waitAndClick(driver,wait,"Continue");


        // Delivery selection
        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,wait,userCredentials.getDeliveryType());
        ClickButtonAfterWait.waitAndClick(driver,wait,"Continue");

        // Card selection

        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,wait,userCredentials.getCardHolderNameForCardSelection());
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
