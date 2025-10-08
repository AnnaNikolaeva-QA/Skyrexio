package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BotPage {
    protected final static SelenideElement BOTS = $x("//button[text()='Боты']");
    protected final static SelenideElement ADD_BOT_BTN = $x("//*[contains(text(), 'Добавить бота')]");
    protected final static SelenideElement ALERT_BOT_BTN = $x("//*[contains(text(), 'Алерт')]");
    protected final static SelenideElement CREATE_BOT_BTN = $x("//*[contains(text(), 'Создать')]");
    protected final static SelenideElement BOT_NAME_INPUT = $x("//*[@placeholder ='Введите новое имя']");
    protected final static SelenideElement CONFIRM_BTN = $x("//*[contains(text(), 'Confirm')]");
    protected final static SelenideElement BOT_NAME = $x("//*[@class = 'tw-text-[24px] tw-text-[#3A3A3C] tw-font-normal tw-max-w-[245px] tw-truncate']");

    public BotPage addBots() {
        BOTS.hover();
        ADD_BOT_BTN.click();
        return this;
    }

    public BotPage chooseAlertBot() {
        ALERT_BOT_BTN.click();
        return this;
    }

    public BotPage createBot(String botName) {
        CREATE_BOT_BTN.click();
        BOT_NAME_INPUT.setValue(botName);
        CONFIRM_BTN.click();
        return this;
    }

    public void checkCreatedBot(String botName) {
        BOT_NAME.shouldHave(text(botName));
    }
}
