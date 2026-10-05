package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    final SelenideElement emailInput = $("#login-email");
    final SelenideElement passwordInput = $("#login-password");
    final SelenideElement loginButton = $("#login-submit");
    final SelenideElement successMessage = $("#login-success");
    final SelenideElement pageTitle = $x("//h2[text()='Login to Your Practice Account']");
    final SelenideElement errorMessage = $("#login-error");
    final SelenideElement forgotPasswordLink = $("#login-forgot-password");
    final SelenideElement registerLink = $("#login-register");

    public LoginPage openPage() {
        open("practice-login-form");
        return this;
    }

    public LoginPage login(String email, String password) {
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
        return this;
    }

    public LoginPage waitPageOpened() {
        pageTitle.should(exist).shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    public LoginPage checkSuccessMessage(String expectedMessage) {
        successMessage.shouldHave(exactText(expectedMessage));
        return this;
    }

    public LoginPage checkErrorMessage(String expectedMessage) {
        errorMessage.shouldHave(exactText(expectedMessage));
        return this;
    }

    public LoginPage checkPasswordIsMasked() {
        passwordInput.shouldHave(attribute("type", "password"));
        return this;
    }

    public ForgotPasswordPage clickForgotPassword() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

    public RegistrationPage clickRegister() {
        registerLink.click();
        return new RegistrationPage();
    }
}
