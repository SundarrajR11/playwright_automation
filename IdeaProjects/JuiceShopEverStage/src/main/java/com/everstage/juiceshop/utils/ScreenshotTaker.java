package com.everstage.juiceshop.utils;

import com.everstage.juiceshop.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotTaker {
    private ScreenshotTaker(){}

    public static String getScreenshotAsBaseString(){
        return ((TakesScreenshot) DriverManager.getInstance()).getScreenshotAs(OutputType.BASE64);
    }

}
