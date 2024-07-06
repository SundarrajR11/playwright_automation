package com.everstage.juiceshop.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public final class ClickRadioBtnInWebTable {
    private ClickRadioBtnInWebTable(){}

    public static void clickRadioBtnInWebTable(WebDriver driver, WebDriverWait wait, String rowLocator, String columnLocator, String baseRadiobtn, String selection) {
        List<WebElement> rows = driver.findElements(By.xpath(rowLocator));
        outerLoop:
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.xpath(columnLocator));
            for (WebElement column : columns) {
                if (column.getText().contains(selection)) {
                    String desiredXpath = DynamicXpath.getDesiredXpath(baseRadiobtn, selection);
                    WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(desiredXpath)));
                    radioBtn.click();
                    break outerLoop;
                }
            }
        }
    }

}
