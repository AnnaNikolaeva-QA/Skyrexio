package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    protected static final SelenideElement HOME_LINK = $x("//*[@class = 'active' and @href='/home']");

    public void checkCorrectLogin() {
        HOME_LINK.shouldBe(visible);
    }
}
