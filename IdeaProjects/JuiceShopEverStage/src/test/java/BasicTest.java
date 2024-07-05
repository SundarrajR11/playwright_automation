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

        LoginInputBuilder userCredentials=LoginInputBuilder.builder()
                 .setEmail("ragusundar935@gmail.com")
                 .setPassword("SunJuice@11")
                 .build();

        /* "//div[contains(text(),'Apple Juice (1000ml)')]/../../following-sibling::div/button"*/
        String baseXpath="//div[contains(text(),'%s')]/../../following-sibling::div/button";
        String salesmanArtwork = DynamicXpath.getDesiredXpath(baseXpath, "Banana Juice (1000ml)");
        System.out.println(salesmanArtwork);

        WebDriver driver=new ChromeDriver();
        driver.get("http://localhost:3000/#/login");
        driver.manage().window().maximize();

        /*issue -1
        * Synchronized */
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Dismiss']//ancestor::button"))).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userCredentials.getEmail());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(userCredentials.getPassword());
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();
        driver.findElement(By.xpath("//div[@role='dialog']//descendant::a[contains(text(),'Me want it')]")).click();



       /* WebElement button= driver.findElement(By.xpath(salesmanArtwork));*/
        /*
        * Synchronized issue and
        * NoSuchElementException ->driver.findElement(By.xpath(salesmanArtwork)).click();
        * ElementClickInterceptedException -> wait.until(ExpectedConditions.elementToBeClickable(By.xpath(salesmanArtwork))).click();
        *  */

        WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(salesmanArtwork)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Your Basket')]//ancestor::button"))))
                .click();
        ((JavascriptExecutor) driver).executeScript("location.reload()");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'Checkout')]/parent::button"))))
                .click();

        List<WebElement> rows =driver.findElements(By.xpath("//mat-table[@role='table']/child::mat-row[@role='row']"));
        List<WebElement> columns =driver.findElements(By.xpath("//mat-table[@role='table']/mat-row/mat-cell[@role='cell']"));

        outerLoop:for (WebElement row: rows) {
                        for (WebElement column: columns) {
                            if(column.getText().equalsIgnoreCase("Name")){
                                    column.click();
                                    Thread.sleep(3000);
                                    break outerLoop;
                }
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[.='Continue']//ancestor::button")))).click();

        List<WebElement> rowsDel =driver.findElements(By.xpath("//mat-table[@role='table']/child::mat-row[@role='row']"));
        List<WebElement> columnsDel =driver.findElements(By.xpath("//mat-table[@role='table']/mat-row/mat-cell[@role='cell']"));

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
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Continue']//ancestor::button")))).click();

        List<WebElement> rowsPay =driver.findElements(By.xpath("//mat-table[@role='table']/child::mat-row[@role='row']"));
        List<WebElement> columnsPay =driver.findElements(By.xpath("//mat-table[@role='table']/mat-row/mat-cell[@role='cell']"));
        String name="HDFC";
        outerLoop:for (WebElement row: rowsPay) {
            for (WebElement column: columnsPay) {
                if(column.getText().contains(name)){
                    System.out.println(column.getText());
                    String desiredXpath=DynamicXpath.
                            getDesiredXpath("//mat-table[@role='table']/mat-row/mat-cell[@role='cell' and contains(text(),'%s')]/preceding-sibling::mat-cell/mat-radio-button",name);
                    wait.until(ExpectedConditions
                            .elementToBeClickable(driver.findElement(By.xpath(desiredXpath)))).click();
                    Thread.sleep(3000);
                    break outerLoop;
                }
            }
        }
        wait.until(ExpectedConditions
                .visibilityOf(driver.findElement(By.xpath("//span[.='Continue']//ancestor::button")))).click();

        wait.until(ExpectedConditions
                .elementToBeClickable(driver.findElement(By.xpath("//span[.='Place your order and pay']//ancestor::button")))).click();

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
