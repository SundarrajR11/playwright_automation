import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.customexceptions.FrameworkException;
import com.everstage.juiceshop.utils.DynamicXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class ClickRadioBtnInWebTable {
    private ClickRadioBtnInWebTable(){}

    public static void clickRadioBtnInWebTable(WebDriver driver,WebDriverWait wait,String selection) {
        List<WebElement> rowsPay =driver.findElements(By.xpath(Locators.getTABLE_ROW()));
        List<WebElement> columnsPay =driver.findElements(By.xpath(Locators.getTABLE_ROW()));
        outerLoop:for (WebElement row: rowsPay) {
            for (WebElement column: columnsPay) {
                if(column.getText().contains(selection)){
                    String desiredXpath= DynamicXpath.
                            getDesiredXpath(Locators.getBASE_RADIO(),selection);
                    wait.until(ExpectedConditions
                            .elementToBeClickable(driver.findElement(By.xpath(desiredXpath)))).click();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    break outerLoop;
                }
            }
        }
    }

}
