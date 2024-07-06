package com.everstage.juiceshop.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class DriverManager {
    private DriverManager(){}
    private static WebDriver instance;

    public static WebDriver getInstance(){
        if (Objects.isNull(instance)) {
            instance=new ChromeDriver();
        }
        return instance;
    }

}
