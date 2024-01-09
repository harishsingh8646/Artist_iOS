package artist.tests;

import artist.appbase.ArtistAppBase;
import artist.pageobject.RegisterPage;
import framework.utilities.EmailUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static framework.configurations.Configuration.appConfig;

public class RegisterTest extends ArtistAppBase {

    RegisterPage registerPage;

//    String emailSignup = appConfig.getProperty("signup.email");
    String emailSignup = EmailUtils.generateRandomEmail();
    String pswd = appConfig.getProperty("user.pswd");

    @BeforeClass
    public void setup() { registerPage = new RegisterPage(driver); }

    /**
     * To verify the signup functionality till OTP page.
     * @throws Exception
     */
    @Test(priority = 0, invocationCount = 1)
    public void creatorSignup() throws Exception {
        extentTest.info("signup for creator with right details till OTP page");
        Assert.assertEquals(registerPage.signup(emailSignup, pswd),"One Time Password");
    }


    /**
     * To Get the OTP from Mail using chrome browser.
     */
//    @Test(priority = 1)
    public void getOTPFromMail() {
        extentTest.info("Get the OTP from Mail using browser");
        registerPage.getOTPValue(emailSignup);

    }
    
}
