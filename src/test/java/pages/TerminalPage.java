package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TerminalPage {
    protected static final SelenideElement TERMINAL = $x("//*[contains(text(), 'Терминал')]");
    protected static final SelenideElement SMART_TERMINAL = $x("//*[contains(text(), 'Создавайте и управляйте')]");
    protected static final SelenideElement PRICE_ORDER_INPUT = $x("//*[contains(text(), 'Цена ордера')]/following::input[1]");
    protected static final SelenideElement CREATE_DEAL_BTN = $x("//*[contains(text(), 'Создать сделку')]");
    protected static final SelenideElement CONFIRM_DEAL_MSG = $x("//*[contains(text(), 'Подтвердите вашу сделку')]");
    protected static final SelenideElement CONFIRM_DEAL_BTN = $x("//*[contains(text(), 'Подтвердить')]");

    public TerminalPage cursorOnTerminal() {
        TERMINAL.hover();
        return this;
    }

    public TerminalPage openSmartTerminalPage() {
        SMART_TERMINAL.should(exist)
                .shouldBe(visible)
                .click();
        return this;
    }

    public void createDeal() {
        actions().scrollByAmount(0, 800).perform();
        PRICE_ORDER_INPUT.shouldNotHave(attribute("value", "0"));
        CREATE_DEAL_BTN.shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        CONFIRM_DEAL_BTN.shouldBe(enabled)
                .click();
    }

    public void verifyDealCreated() {
        CONFIRM_DEAL_MSG.should(disappear);
    }
}
