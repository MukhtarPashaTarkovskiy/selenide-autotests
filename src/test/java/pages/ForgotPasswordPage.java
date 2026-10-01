package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class ForgotPasswordPage {
    final SelenideElement pageTitle = $x("//h1[text()='Master Password Recovery Automation']");

    public void openPage() {
        open("forget-password");
    }

    public void checkPageOpened() {
        pageTitle.shouldHave(exactText("Master Password Recovery Automation"));
    }
}
