package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement LOGIN_INPUT = $x("//*[@placeholder='Email']");
    private final SelenideElement PASSWORD_INPUT = $x("//*[@placeholder='Пароль']");
    private final SelenideElement ENTER_BUTTON = $x("//*[@type='submit']");

    public LoginPage openPage() {
        open("");
        return this;
    }

    public LoginPage login() {
        LOGIN_INPUT.setValue("niolan007@yandex.ru");
        PASSWORD_INPUT.setValue("O123456*");
        return this;
    }

    public void pressLoginButton() {
        ENTER_BUTTON.click();
    }
}
