package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    final SelenideElement pageTitle =
            $x("//h1[text()='Master Registration Automation']");

   public void openPage() {
        open("register");
    }

    public void checkPageOpened() {
        pageTitle.shouldHave(exactText("Master Registration Automation"));
    }
}
