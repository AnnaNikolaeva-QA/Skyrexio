package tests;

import org.testng.annotations.Test;

public class TerminalTest extends BaseTest {
    @Test
    public void checkCreateDeal() {
        loginPage.openPage()
                .login()
                .pressLoginButton();
        terminalPage.cursorOnTerminal()
                .openSmartTerminalPage()
                .createDeal();
        terminalPage.verifyDealCreated();
    }
}
