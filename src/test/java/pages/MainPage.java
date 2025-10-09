package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    protected static final SelenideElement HOME_LINK = $x("//*[@class = 'active' and @href='/home']");

    @Step("Проверка успешной аутентификации")
    public void checkCorrectLogin() {
        HOME_LINK.shouldBe(visible);
    }
}
