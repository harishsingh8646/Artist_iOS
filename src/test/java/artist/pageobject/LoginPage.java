package artist.pageobject;

import framework.generics.Generic;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    IOSDriver driver;

    public LoginPage(IOSDriver driver) {
        this.driver = driver;
    }

    By userID = new By.ByXPath("(//XCUIElementTypeOther[@name=\"Email Address\"])[2]/XCUIElementTypeTextField");
    By userPswd = new By.ByXPath("(//XCUIElementTypeOther[@name=\"Password\"])[2]/XCUIElementTypeSecureTextField");
    By loginBtn = new By.ById("com.teamcommunication:id/btnLogin");
    String otpMSG = "//android.widget.TextView[contains(@text,'Kindly enter the OTP')]";
    public void typeID(String emailID) { driver.findElement(userID).sendKeys(emailID); }
    public void typePswd(String pswd) { driver.findElement(userPswd).sendKeys(pswd);}

    public void clickLogout() throws Exception{
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"50\"])[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeOther[@name=\"Logout\"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"YES\"]")).click();
//        Thread.sleep(2000);
//        System.out.println(driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Or Connect With\"]")).getText());
//        return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Or Connect With\"]")).getText();
    }

    public String clickLogin() throws Exception{

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]"))));
//        element.click();

        Generic.isElementPresent(driver,"(//XCUIElementTypeOther[@name=\"Login\"])[2]");


        Thread.sleep(2000);
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name=\"Login\"])[2]")).click();

//        System.out.println(driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Home']")).getText());
        return driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Home']")).getText();
    }


}
