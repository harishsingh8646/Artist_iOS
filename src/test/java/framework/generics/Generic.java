package framework.generics;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.HashMap;

import static artist.appbase.ArtistAppBase.*;

public class Generic {

    static Actions actions;


    public static void initialiseExtentReports() {
        ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter_all);
    }

    public static void generateExtentReports() { extentReports.flush(); }

    public static void checkStatus(Method m, ITestResult result, WebDriver driver) throws Exception {
        if(result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = null;
            screenshotPath = captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod()+".jpg",driver);
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.fail(result.getThrowable());
        } else if(result.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(m.getName() + " is passed");
        }
    }


    public static String captureScreenshot(String fileName, WebDriver driver) {

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./Screenshots/"+ fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
        return destFile.getAbsolutePath();
    }


    public static void launchApp(String bundle_ID, IOSDriver iosDriver){
        HashMap<String, Object> args = new HashMap<>();
        args.put("bundleId", bundle_ID);
        try{
            ((IOSDriver)iosDriver).executeScript("mobile: launchApp",args);
        }catch(Exception e){
            System.err.println("launchApp(): Failed\n"+e.getMessage());
        }
    }


    public static void singleScroll(IOSDriver iosDriver) {
        Dimension dimensions = iosDriver.manage().window().getSize();
        int startX = dimensions.getWidth() / 2;
        int startY = (int) (dimensions.getHeight() * 0.6);
        int endY = (int) (dimensions.getHeight() * 0.2);

        TouchAction action = new TouchAction(iosDriver);
        action.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(startX, endY))
                .release().perform();
    }


    public static boolean isElementPresent(IOSDriver iosDriver, String elementXpath) {

        try {
            WebElement element = iosDriver.findElement(By.xpath(""+elementXpath+""));

            if (element.isDisplayed()) {
                System.out.println("Element is present and visible.");
            } else {
                System.out.println("Element is present but not visible.");
            }
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element is not present on the page.");
            return false;
        }
    }


    public static boolean isElementClickable(IOSDriver driver, By locator) {
        try {
            WebElement element =  driver.findElement(locator);
            System.out.println(element.isEnabled());
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }


//    public static boolean isElementClickable(WebDriver driver, By locator, int timeoutInSeconds) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//            wait.until(ExpectedConditions.elementToBeClickable(locator));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }


    public static WebElement explicitWaitTillElementVisible(IOSDriver driver, By locator) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }


    public static void performMultipleClicks(IOSDriver driver, WebElement element, int numberOfClicks) {
        actions = new Actions(driver);

        for (int i = 0; i < numberOfClicks; i++)
            actions.click(element);

        actions.build().perform();
    }

    public static void doubleClick(IOSDriver driver, WebElement element) {
        actions = new Actions(driver);
        actions.doubleClick(element).build().perform();
    }




}
