package tests;

import data.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"", "", "Email and Password are required"},
                {TestData.EMAIL, "", "Password is required"},
                {"", TestData.PASSWORD, "Email is required"},
                {"wrong@example.com", "WrongPassword123", "Invalid email id and password"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(String email, String password, String expectedMessage) {
        loginPage.openPage();
        loginPage.waitPageOpened();
        loginPage.login(email, password);
        loginPage.checkErrorMessage(expectedMessage);
    }

    @Test
    public void successfulLoginTest() {
        loginPage.openPage();
        loginPage.waitPageOpened();
        loginPage.login(TestData.EMAIL, TestData.PASSWORD);
        loginPage.checkSuccessMessage(TestData.SUCCESS_LOGIN_MESSAGE);
    }

    @Test
    public void passwordIsMaskedTest() {
        loginPage.openPage();
        loginPage.waitPageOpened();
        loginPage.checkPasswordIsMasked();
    }

    @Test
    public void forgotPasswordNavigationTest() {
        loginPage.openPage();
        loginPage.waitPageOpened();
        loginPage.clickForgotPassword();
        forgotPasswordPage.checkPageOpened();
    }

    @Test
    public void registrationNavigationTest() {
        loginPage.openPage();
        loginPage.waitPageOpened();
        loginPage.clickRegister();
        registrationPage.checkPageOpened();
    }
}
