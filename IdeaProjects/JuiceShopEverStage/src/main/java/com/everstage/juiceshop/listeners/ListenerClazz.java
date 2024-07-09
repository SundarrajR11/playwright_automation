package com.everstage.juiceshop.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.everstage.juiceshop.constants.FrameworkConstants;
import com.everstage.juiceshop.reports.ExtentReport;
import lombok.SneakyThrows;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class ListenerClazz implements ISuiteListener , ITestListener {

    private static ExtentReports extent;
    private static ExtentTest test;

    @Override
    @SneakyThrows
    public void onStart(ISuite suite) {
        extent = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getEXTENT_FOLDER_PATH());
        sparkReporter.loadJSONConfig(new File(FrameworkConstants.getSPARK_SETUP_FILE_PATH()));
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass(String.format("%s is Passed!",result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(String.format("%s is Failed!",result.getMethod().getMethodName()));
        test.fail(result.getThrowable());
        
    }

    @Override
    @SneakyThrows
    public void onFinish(ISuite suite) {
        extent.flush();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getEXTENT_FOLDER_PATH()).toURI());
    }
}
