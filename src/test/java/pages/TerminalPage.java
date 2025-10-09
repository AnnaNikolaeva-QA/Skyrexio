package pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.*;

public class TerminalPage {
    protected static final SelenideElement TERMINAL = $x("//*[contains(text(), 'Терминал')]");
    protected static final SelenideElement SMART_TERMINAL = $x("//*[contains(text(), 'Создавайте и управляйте')]");
    protected static final SelenideElement TRADING_DIARY = $x("//*[contains(text(), 'Торговый дневник')]");
    protected static final SelenideElement PRICE_ORDER_INPUT = $x("//*[contains(text(), 'Цена ордера')]/following::input[1]");
    protected static final SelenideElement CREATE_DEAL_BTN = $x("//*[contains(text(), 'Создать сделку')]");
    protected static final SelenideElement CONFIRM_DEAL_MSG = $x("//*[contains(text(), 'Подтвердите вашу сделку')]");
    protected static final SelenideElement CONFIRM_DEAL_BTN = $x("//*[contains(text(), 'Подтвердить')]");
    protected static final SelenideElement SORTED_BY_DATA_BTN = $x("//*[text()='Дата создания']/child::*[@class = 'lucide lucide-arrow-up-down']");
    protected static final SelenideElement SORTED_BY_PROFIT_BTN = $x("//*[text()='Доход']/child::*[@class = 'lucide lucide-arrow-up-down']");
    protected static final ElementsCollection DATA_LIST = $$("span").filterBy(matchText("\\d{2}\\.\\d{2}\\.\\d{4}, \\d{2}:\\d{2}:\\d{2}"));
    protected static final ElementsCollection PROFIT_LIST = $$("span").filterBy(matchText("[-+]?\\d+\\.\\d+\\s*\\(\\s*[-+]?\\d+\\.\\d+%\\)"));

    @Step("навод курсора на значок терминал")
    public TerminalPage cursorOnTerminal() {
        TERMINAL.hover();
        return this;
    }

    @Step("переход в смарт-терминал")
    public TerminalPage openSmartTerminalPage() {
        SMART_TERMINAL.should(exist)
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("создание сделки со значенияями по умолчанию")
    public void createDeal() {
        actions().scrollByAmount(0, 800).perform();
        PRICE_ORDER_INPUT.shouldNotHave(attribute("value", "0"));
        CREATE_DEAL_BTN.shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        CONFIRM_DEAL_BTN.shouldBe(enabled)
                .click();
    }

    @Step("Проверка создания сделки")
    public void verifyDealCreated() {
        CONFIRM_DEAL_MSG.should(disappear);
    }

    @Step("Проверка сортировки сделок по дате создания по возрастанию")
    public void checkSortedDealByDate() {
        TRADING_DIARY.click();
        SORTED_BY_DATA_BTN.click();
        List<LocalDateTime> dates = DATA_LIST.texts()
                .stream()
                .map(text -> LocalDateTime.parse(text, DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm:ss")))
                .toList();
        List<LocalDateTime> sortedAsc = new ArrayList<>(dates);
        sortedAsc.sort(Comparator.naturalOrder());
        assertThat(dates).isEqualTo(sortedAsc);
    }

    @Step("проверка создания сделок по доходу по убыванию")
    public void checkSortedDealByProfit() {
        TRADING_DIARY.click();
        SORTED_BY_PROFIT_BTN.click();
        SORTED_BY_PROFIT_BTN.click();
        List<Double> profit = PROFIT_LIST.texts()
                .stream()
                .map(text -> text.split(" ")[0])
                .map(Double::parseDouble)
                .toList();
        List<Double> sortedDesc = new ArrayList<>(profit);
        sortedDesc.sort(Comparator.reverseOrder());
        assertThat(profit).isEqualTo(sortedDesc);
    }
}
