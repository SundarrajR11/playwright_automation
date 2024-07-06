import com.everstage.juiceshop.utils.ClickButtonAfterWait;
import com.everstage.juiceshop.utils.ClickRadioBtnInWebTable;
import com.everstage.juiceshop.utils.DynamicXpath;
import com.everstage.juiceshop.utils.JavaScriptRunner;
import org.openqa.selenium.By;
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

        //Cookies Button
        driver.findElement(By.xpath(Locators.getBUTTON_ME_WANT_IT())).click();

        // Product Selection
        String desiredProduct = DynamicXpath.getDesiredXpath(Locators.getBASE_PRODUCT(),userCredentials.getProduct());
        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desiredProduct)));
        JavaScriptRunner.runJavaScript(driver,button,"arguments[0].click();");

        // Navigate to Your Basket
        ClickButtonAfterWait.waitAndClick(driver,wait,Locators.getBASE_BUTTON(),"Your Basket");

        // Checkout Page
        JavaScriptRunner.runJavaScript(driver,"location.reload()");
        ClickButtonAfterWait.waitAndClick(driver,wait,Locators.getBASE_BUTTON(),"Checkout");


        // Address selection
        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,wait,Locators.getTABLE_ROW(),Locators.getTABLE_COLUMN(),Locators.getBASE_RADIOBUTTON(),userCredentials.getNameForAddressSelection());
        ClickButtonAfterWait.waitAndClick(driver,wait,Locators.getBASE_BUTTON(),"Continue");


        // Delivery selection
        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,wait,Locators.getTABLE_ROW(),Locators.getTABLE_COLUMN(),Locators.getBASE_RADIOBUTTON(),userCredentials.getDeliveryType());
        ClickButtonAfterWait.waitAndClick(driver,wait,Locators.getBASE_BUTTON(),"Continue");

        // Card selection

        ClickRadioBtnInWebTable.clickRadioBtnInWebTable(driver,wait,Locators.getTABLE_ROW(),Locators.getTABLE_COLUMN(),Locators.getBASE_RADIOBUTTON(),userCredentials.getCardHolderNameForCardSelection());
        ClickButtonAfterWait.waitAndClick(driver,wait,Locators.getBASE_BUTTON(),"Continue");

        // Place Order Page

        ClickButtonAfterWait.waitAndClick(driver,wait,Locators.getBASE_BUTTON(),"Place your order and pay");

        //Assertion
        List<WebElement> elements = (List<WebElement>)JavaScriptRunner
                .runJavaScriptAndReturnObject(driver,"return document.getElementsByClassName('confirmation');");

        for (WebElement element:
                elements) {
            boolean isConfirmationHeaderDisplayed =  element.isDisplayed();
            Assert.assertTrue(isConfirmationHeaderDisplayed,"Assertion Failed");
        }

    }
}
