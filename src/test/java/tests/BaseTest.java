package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
LoginPage loginPage;
RegistrationPage registrationPage;
ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.qapractice.com/";
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;

        loginPage = new LoginPage();
        registrationPage = new RegistrationPage();
        forgotPasswordPage = new ForgotPasswordPage();
    }

    @AfterMethod
    public void close() {
        cookies().clear();
        closeWebDriver();
    }
}
