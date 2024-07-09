package com.everstage.juiceshop.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.utils.ScreenshotTaker;
import lombok.SneakyThrows;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;

public class ExtentReport {
    private ExtentReport(){}
    private static ExtentReports extent;
    private static ExtentTest test;

    @SneakyThrows
    public static void initReports(){
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getEXTENT_FOLDER_PATH());
        sparkReporter.loadJSONConfig(new File(FrameworkConstants.getSPARK_SETUP_FILE_PATH()));
        extent.attachReporter(sparkReporter);
    }
    @SneakyThrows
    public static void flushReports(){
        extent.flush();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getEXTENT_FOLDER_PATH()).toURI());
    }
    public static void createTest(ITestResult result){
        test=extent.createTest(result.getMethod().getMethodName());
    }
    public static void pass(ITestResult result){
        test.pass(String.format("%s is Passed!",result.getMethod().getMethodName()));
    }
    public static void fail(ITestResult result){
        test.fail(String.format("%s is Failed!",result.getMethod().getMethodName()),
                MediaEntityBuilder.createScreenCaptureFromBase64String(
                        ScreenshotTaker.getScreenshotAsBaseString()
                ).build());
        test.fail(result.getThrowable());
    }
}
