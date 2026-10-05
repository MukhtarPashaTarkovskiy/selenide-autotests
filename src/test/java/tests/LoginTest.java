package tests;

import data.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

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
        loginPage
                .openPage()
                .waitPageOpened()
                .login(email, password)
                .checkErrorMessage(expectedMessage);
    }

    @Test
    public void successfulLoginTest() {
        loginPage
                .openPage()
                .waitPageOpened()
                .login(TestData.EMAIL, TestData.PASSWORD)
                .checkSuccessMessage(TestData.SUCCESS_LOGIN_MESSAGE);
    }

    @Test
    public void passwordIsMaskedTest() {
        loginPage
                .openPage()
                .waitPageOpened()
                .checkPasswordIsMasked();
    }

    @Test
    public void forgotPasswordNavigationTest() {
        loginPage
                .openPage()
                .waitPageOpened()
                .clickForgotPassword()
                .checkPageOpened();
    }

    @Test
    public void registrationNavigationTest() {
        loginPage
                .openPage()
                .waitPageOpened()
                .clickRegister()
                .checkPageOpened();
    }
}
