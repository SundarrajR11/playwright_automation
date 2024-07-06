package com.everstage.juiceshop.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class JavaScriptRunner {
    private JavaScriptRunner(){}

    public static void runJavaScript(WebDriver driver, String javaScript){
        ((JavascriptExecutor) driver).executeScript(javaScript);
    }
    public static void runJavaScript(WebDriver driver, WebElement element, String javaScript){
        ((JavascriptExecutor) driver).executeScript(javaScript, element);
    }

    public static Object runJavaScriptAndObject(WebDriver driver, String javaScript){
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

}
