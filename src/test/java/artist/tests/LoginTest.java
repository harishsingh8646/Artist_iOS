package artist.tests;

import artist.appbase.ArtistAppBase;
import artist.pageobject.LoginPage;
import framework.generics.Generic;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static framework.configurations.Configuration.appConfig;


public class LoginTest extends ArtistAppBase {
    LoginPage loginPage;
    String emailID = appConfig.getProperty("login.email");
    String pswd = appConfig.getProperty("user.pswd");

    @BeforeClass
    public void initialize() { loginPage = new LoginPage(driver); }

    @BeforeMethod
    public void checkAppStatus() throws Exception {


        if(Generic.isElementPresent(driver,"//XCUIElementTypeOther[@name='Home']"))
            logoutApp();

//        driver.resetApp();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Login \"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Login \"]")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Login \"]")).click();

    }


    /**
     * Positive LogIn test
     *
     * @throws Exception
     */
    @Test(invocationCount = 5)
    public void login_Test1() throws Exception {

        extentTest.info("logging in application with right credentials");

        Thread.sleep(2000);
        loginPage.typeID(emailID);
        loginPage.typePswd(pswd);

//        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]")).click();
        Assert.assertEquals(loginPage.clickLogin(),"Home");


//        WebElement Element = driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();",Element );

//        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]")).click();
    }


    /**
     * Negative username test
     */
//    @Test
    public void login_Test2() throws Exception{

        extentTest.info("logging in application with wrong username and right password");

        Thread.sleep(2000);
        loginPage.typeID("george@yopmail.com");
        loginPage.typePswd(pswd);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]")).click();

        Assert.assertTrue(Generic.isElementPresent(driver,"//XCUIElementTypeOther[@name=\"Login \"]"));

    }

//    /**
//     * Negative Password test
//     */
//    @Test
//    public void login_Test3() {
//
//        extentTest.info("logging in application with right username and wrong password");
//        loginPage.typeID(emailID);
//        loginPage.typePswd("user@123");
//        driver.findElement(By.id("com.teamcommunication:id/btnLogin")).click();
//
//        Assert.assertTrue(Generic.isElementPresent(driver,"//android.widget.TextView[@text='Login']"));
//
//    }
//
//    /**
//     * Blank userName and Right Password
//     */
//    @Test
//    public void login_Test4() {
//
//        extentTest.info("logging in application with blank username and right password");
//        loginPage.typeID("");
//        loginPage.typePswd(pswd);
//        driver.findElement(By.id("com.teamcommunication:id/btnLogin")).click();
//
//        Assert.assertTrue(Generic.isElementPresent(driver,"//android.widget.TextView[@text='Login']"));
//
//    }
//
//    /**
//     * Right UserName and Blank Password
//     */
//    @Test
//    public void login_Test5() {
//
//        extentTest.info("logging in application with right username and blank password");
//        loginPage.typeID(emailID);
//        loginPage.typePswd("");
//        driver.findElement(By.id("com.teamcommunication:id/btnLogin")).click();
//
//        Assert.assertTrue(Generic.isElementPresent(driver,"//android.widget.TextView[@text='Login']"));
//
//    }
//
//    /**
//     * Blank UserName and Blank Password
//     */
//    @Test
//    public void login_Test6() {
//
//        extentTest.info("logging in application with blank username and blank password");
//        loginPage.typeID("");
//        loginPage.typePswd("");
//        driver.findElement(By.id("com.teamcommunication:id/btnLogin")).click();
//
//        Assert.assertTrue(Generic.isElementPresent(driver,"//android.widget.TextView[@text='Login']"));
//
//    }


    public void logoutApp() throws Exception {
        extentTest.info("logout from application");
        loginPage.clickLogout();
//        Assert.assertEquals(loginPage.clickLogout(),"Or Connect With");

    }

}
