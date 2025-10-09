package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("Терминал")
public class TerminalTest extends BaseTest {
    @Feature("Сделки")
    @Story("ID3")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Nikolaeva Ann niolan007@yandex.ru")
    @TmsLink("SwagLabs")
    @Issue("Sandbox")
    @Test(description = "Создание сделки в терминале со значениями поу молчанию")
    public void checkCreateDeal() {
        loginPage.openPage()
                .login();
        terminalPage.cursorOnTerminal()
                .openSmartTerminalPage()
                .createDeal();
        terminalPage.verifyDealCreated();
    }

    @Test(description = "Проверка фильтрации сделок по дате по убыванию")
    public void checkFilterDealsByDate() {
        loginPage.openPage()
                .login();
        terminalPage.cursorOnTerminal()
                .checkSortedDealByDate();
    }

    @Test(description = "Проверка фильтрации сделок по доходу по возрастанию")
    public void checkFilterDealByProfit() {
        loginPage.openPage()
                .login();
        terminalPage.cursorOnTerminal()
                .checkSortedDealByProfit();
    }
}
