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

    public void openPage() {
        open("practice-login-form");
    }

    public void login(String email, String password) {
      emailInput.setValue(email);
      passwordInput.setValue(password);
      loginButton.click();
    }

    public void waitPageOpened() {
        pageTitle.should(exist).shouldBe(visible, Duration.ofSeconds(10));
    }

    public void checkSuccessMessage(String expectedMessage) {
        successMessage.shouldHave(exactText(expectedMessage));
    }

    public void checkErrorMessage(String expectedMessage) {
        errorMessage.shouldHave(exactText(expectedMessage));
    }

    public void checkPasswordIsMasked() {
        passwordInput.shouldHave(attribute("type","password"));
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public void clickRegister() {
        registerLink.click();
    }
}
