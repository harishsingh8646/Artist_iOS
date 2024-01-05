package artist.pageobject;

import framework.generics.Generic;
import framework.utilities.EmailUtils;
import framework.utilities.PhoneNumberUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static framework.configurations.Configuration.appConfig;


public class RegisterPage {

    public IOSDriver driver;
    String country = "India";

    public RegisterPage(IOSDriver driver) { this.driver = driver; }

    By countryCode = new AppiumBy.ByAccessibilityId("+1");
    By countryName = new By.ByXPath("//XCUIElementTypeScrollView/XCUIElementTypeOther[contains(@name,'"+country+"')]");
    By checkBox = By.xpath("(//XCUIElementTypeOther[@name='I Accept Terms And Conditions'])[1]/XCUIElementTypeOther[1]");
    By registerBtn = By.xpath("(//XCUIElementTypeOther[@name='Register'])[3]");

    By webCrossIcon = By.xpath("//XCUIElementTypeStaticText[@name=\"\uE5CD\"]");

    public String signup(String emailSignup, String pswd) throws Exception {
        driver.findElement(By.id("Sign Up")).click();
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Your Name'])[2]/XCUIElementTypeTextField")).sendKeys("Martin Wood");
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Email Address'])[2]/XCUIElementTypeTextField")).sendKeys(emailSignup);

        WebElement countryCodeElement = driver.findElement(countryCode);
        Generic.performMultipleClicks(driver, countryCodeElement, 2);

        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Search Country'])[2]/XCUIElementTypeTextField")).sendKeys(country);

        WebElement countryNameElement = driver.findElement(countryName);
        Generic.performMultipleClicks(driver, countryNameElement, 2);

        driver.findElement(By.xpath("//XCUIElementTypeOther[@name='Mobile Number']/XCUIElementTypeTextField")).sendKeys(PhoneNumberUtils.generatePhoneNumber());
        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='Password'])[2]/XCUIElementTypeSecureTextField")).sendKeys(pswd);



//        Thread.sleep(2000);
//        Generic.singleScroll(driver);

//        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='I Accept Terms And Conditions'])[1]/XCUIElementTypeOther[1]")).click();
//        driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='I Accept Terms And Conditions'])[1]/XCUIElementTypeOther[1]")).click();


//        Generic.performMultipleClicks(driver, checkBoxElement, 2);

//        WebElement element = Generic.explicitWaitTillElementVisible(driver,elementLocator);
//        element.click();



//        int count=1;
//        while(count<5) {
//
//            if (Generic.isElementClickable(driver, registerBtn))
//                break;
//
//             else
//                driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='I Accept Terms And Conditions'])[1]/XCUIElementTypeOther[1]")).click();
//
//            count++;
//
//        }

//        Thread.sleep(10000);
//        WebElement registerBtnElement = driver.findElement(registerBtn);

//        Thread.sleep(10000);
//
//        WebElement checkBoxElement = driver.findElement(checkBox);
//
//        if (checkBoxElement.isSelected()) {
//            System.out.println("Checkbox is checked.");
//        } else {
//            System.out.println("Checkbox is not checked.");
//        }


//        int count=1;
//        while(count<5) {
//
//            driver.findElement(By.xpath("(//XCUIElementTypeOther[@name='I Accept Terms And Conditions'])[1]/XCUIElementTypeOther[1]")).click();
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//
//            // Check if the element is clickable
//            try {
//                wait.until(ExpectedConditions.elementToBeClickable(registerBtnElement));
//                System.out.println("Element is clickable.");
//            } catch (org.openqa.selenium.TimeoutException e) {
//                System.out.println("Element is not clickable within the timeout.");
//            }
//
//            count++;
//        }


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//XCUIElementTypeOther[@name='I Accept Terms And Conditions'])[1]/XCUIElementTypeOther[1]")));
            element.click();
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable within the timeout.");
        }


        driver.findElement(registerBtn).click();
        return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='One Time Password']")).getText();
    }


    public void getOTPValue(String emailSignup) {
        driver.get("https://yopmail.com/en/");

//        Set<String> contextNames = driver.getContextHandles();
//        for (String c : contextNames) {
//            System.out.println("context " + c);
//
//            /*if (c.contains("WEBVIEW")) {
//                appDriver.context(c);
//                break;
//            }*/
//        }


        try {
            if(driver.findElement(webCrossIcon).isDisplayed()==true) {
                System.out.println("true");
                driver.findElement(webCrossIcon).click();
            }

        } catch (Exception e) {
            System.out.println("false");
//            WebDriverWait wait = new WebDriverWait(driver, 15);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@resource-id='clearbut']")));
//            Thread.sleep(2000);
//            driver.findElement(By.xpath("//android.view.View[@resource-id='clearbut']")).click();

        }




//        WebElement mob=driver.findElementByXPath("//XCUIElementTypeTextField[@name=\"Login\"]");
//        mob.click();
//        mob.clear();
//        mob.sendKeys("harish");
//        Thread.sleep(1000);
//        appDriver.findElementByXPath("//XCUIElementTypeButton[@name=\"\uE5C8\"]").click();
//        Thread.sleep(1000);
//        //driver.findElement(By.xpath("/html")).click();
//        appDriver.findElementByXPath("(//XCUIElementTypeButton[contains(@name,\"New Carbon Voice login request\")])[1]").click();
//
//        Thread.sleep(2000);
//        String s=appDriver.findElementByXPath("(//XCUIElementTypeOther[@name=\"main\"])[2]//XCUIElementTypeOther[1]//XCUIElementTypeStaticText[2]").getText();
//        System.out.println(s);



    }


    public String getOTPFromMail(String emailSignup) throws Exception {
        Thread.sleep(5000);
        driver.findElement(By.id("com.android.chrome:id/url_bar")).click();
        driver.findElement(By.id("com.android.chrome:id/url_bar")).sendKeys("https://yopmail.com/en/");
        driver.findElement(By.id("com.android.chrome:id/line_2")).click();


        try {
            if(driver.findElement(By.xpath("//android.view.View[@resource-id='clearbut']")).isDisplayed()==true)
                driver.findElement(By.xpath("//android.view.View[@resource-id='clearbut']")).click();

        } catch (Exception e) {
        }


        Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.TextView[@text='Type the Email name of your choice']/parent::android.view.View/descendant::android.view.View/android.widget.EditText")).sendKeys(emailSignup);
        driver.findElement(By.xpath("//android.widget.FrameLayout/descendant::android.widget.Button[1]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("(//android.widget.Button[contains(@text,'Team Communication Verify user OTP')])[1]")).click();

        Thread.sleep(3000);
        String str = driver.findElement(By.xpath("//android.webkit.WebView//android.widget.TextView[contains(@text,'Your OTP is')]")).getText();
        str = str.replaceAll("\\D+","");

        return str;
    }


}
