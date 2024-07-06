package com.everstage.juiceshop.utils;

import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.customexceptions.UnableToClickButtonException;
import com.everstage.juiceshop.utils.DynamicXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ClickButtonAfterWait {
    private ClickButtonAfterWait(){}

    public static void waitAndClick(WebDriver driver,WebDriverWait wait,String baseBtnLocator,String buttonName) {
        String desiredButton= DynamicXpath.getDesiredXpath(baseBtnLocator,buttonName);
        try {
            WebElement button=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(desiredButton))));
            button.click();
        } catch (Exception e) {
            throw new UnableToClickButtonException("Failed to find or click the button: " + buttonName);
        }
    }
}
