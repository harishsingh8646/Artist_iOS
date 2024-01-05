package artist.appbase;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import framework.generics.Generic;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArtistAppBase {

    public static IOSDriver driver;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeTest
    public void launchApp(ITestContext context) throws Exception {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.Arttavo.in");
        dc.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, true);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new IOSDriver(url, dc);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        extentTest = extentReports.createTest(context.getName());

    }


    @BeforeSuite
    public void startReports() {
        Generic.initialiseExtentReports();
    }

    @AfterSuite
    public void endReports() {
        Generic.generateExtentReports();
//        driver.close();
    }

    @AfterMethod
    public void findStatus(Method m, ITestResult result) throws Exception {
        Generic.checkStatus(m,result,driver);
    }

    
}
