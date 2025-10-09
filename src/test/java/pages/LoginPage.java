package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private final SelenideElement LOGIN_INPUT = $x("//*[@placeholder='Email']");
    private final SelenideElement PASSWORD_INPUT = $x("//*[@placeholder='Пароль']");
    private final SelenideElement ENTER_BUTTON = $x("//*[@type='submit']");

    @Step("Открытие страницы")
    public LoginPage openPage() {
        open("");
        return this;
    }

    @Step("Аутентификация")
    public void login() {
        LOGIN_INPUT.setValue("niolan007@yandex.ru");
        PASSWORD_INPUT.setValue("O123456*");
        ENTER_BUTTON.click();
    }
}
