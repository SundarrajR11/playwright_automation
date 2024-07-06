package com.everstage.juiceshop.utils;

import com.everstage.juiceshop.customexceptions.NullValueSentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public final class JavaScriptRunner {
    private JavaScriptRunner(){}

    public static void runJavaScript(WebDriver driver, String javaScript){
        validateInputsNullable(driver,javaScript);
        ((JavascriptExecutor) driver).executeScript(javaScript);
    }
    public static void runJavaScript(WebDriver driver, WebElement element, String javaScript){
        validateInputsNullable(driver,javaScript);
        ((JavascriptExecutor) driver).executeScript(javaScript, element);
    }
    public static Object runJavaScriptAndReturnObject(WebDriver driver, String javaScript){
        validateInputsNullable(driver,javaScript);
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }
    private static void validateInputsNullable(WebDriver driver, String js){
        if (Objects.isNull(driver) || Objects.isNull(js)){
            throw new NullValueSentException(driver+" or "+ js +" should not a null");
        }
    }

}
