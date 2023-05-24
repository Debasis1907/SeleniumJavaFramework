package com.store.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentListenerClass implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void initializeReport(){
        ReadConfig readConfig = new ReadConfig();
        String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
        String reportName = "AutomationTestStatusReport-" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//src//test//resources//Reports//" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("User","Debasis");
        reports.setSystemInfo("browser",readConfig.getBrowser());

        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("This is extent report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onStart(ITestContext testContext){
        initializeReport();
        System.out.println("On start method invoked");
    }

    public void onFinish(ITestContext Result){
        System.out.println("On finish method invoked");
        reports.flush();
    }

    public void onTestFailure(ITestResult Result){
        test = reports.createTest(Result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case is : " + Result.getName() , ExtentColor.RED));
        String screenshotPath = System.getProperty("user.dir") + "//src//test//resources//Screenshots//" + Result.getName() + ".png";
        File file = new File(screenshotPath);
        if(file.exists()){
            test.fail("Captured screenshot is below : " + test.addScreenCaptureFromPath(screenshotPath));
        }
        test.addScreenCaptureFromPath(screenshotPath);
    }

    public void onTestSuccess(ITestResult Result)
    {
        System.out.println("Name of test method sucessfully executed:" + Result.getName() );

        test = reports.createTest(Result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
    }

    public void onTestSkipped(ITestResult Result)
    {
        System.out.println("Name of test method skipped:" + Result.getName() );

        test = reports.createTest(Result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
    }

    // When Test case get Started, this method is called.

    public void onTestStart(ITestResult Result)
    {
        System.out.println("Name of test method started:" + Result.getName() );

    }

    public void onTestFailedButWithinSuccessPercentage(ITestContext Result)
    {

    }
}
