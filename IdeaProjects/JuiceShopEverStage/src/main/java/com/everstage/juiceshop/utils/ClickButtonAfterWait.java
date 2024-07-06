package com.everstage.juiceshop.utils;

import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.utils.DynamicXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ClickButtonAfterWait {
    private ClickButtonAfterWait(){}

    public static void waitAndClick(WebDriver driver,WebDriverWait wait,String baseBtnLocator,String buttonName) {
        String desiredButton= DynamicXpath.getDesiredXpath(baseBtnLocator,buttonName);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(desiredButton)))).click();
    }
}
