import com.everstage.juiceshop.pojo.LoginInputBuilder;
import com.everstage.juiceshop.utils.DynamicXpath;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasicTest {

    @Test
    public void Test() throws InterruptedException {

        LoginInputBuilder userCredentials=LoginInputBuilder.builder()
                 .setEmail("")
                 .setPassword("")
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
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[.='Dismiss']//ancestor::button"))).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userCredentials.getEmail());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(userCredentials.getPassword());
        driver.findElement(By.xpath("//button[@id='loginButton']")).click();


       /* WebElement button= driver.findElement(By.xpath(salesmanArtwork));*/
        /*
        * Synchronized issue and
        * NoSuchElementException ->driver.findElement(By.xpath(salesmanArtwork)).click();
        * ElementClickInterceptedException -> wait.until(ExpectedConditions.elementToBeClickable(By.xpath(salesmanArtwork))).click();
        *  */
        /*WebElement button= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(salesmanArtwork)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);*/
        //mat-cell[contains(text(),'%s')]
        // btn= //*[contains(text(),' Checkout ')]/parent::button
        // Address radio =//mat-cell[contains(text(),'AA')]/preceding-sibling::mat-cell/mat-radio-button -same
        // continue =//span[.='Continue']/../.. or //span[.='Continue']//ancestor::button
        // delivery radio = //mat-cell[contains(text(),'Standard Delivery')]//preceding-sibling::mat-cell/mat-radio-button
        // Payment radio = //mat-cell[contains(text(),'ACSQ')]//preceding-sibling::mat-cell/mat-radio-button




    }
}
