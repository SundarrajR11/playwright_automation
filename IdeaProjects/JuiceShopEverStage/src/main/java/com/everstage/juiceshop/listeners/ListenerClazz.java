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

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReport.pass(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReport.fail(result);
    }

}
