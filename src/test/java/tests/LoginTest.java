package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void checkCorrectLogin() {
        loginPage.openPage()
                .login()
                .pressLoginButton();
        mainPage.checkCorrectLogin();
    }
}
