package test;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UkrNetMainPage;

import static data.UkrNetConstans.*;

public class UkrNetLogInPositiveTest extends BaseTest {

    @BeforeMethod
    public void openSite() {
        setUp().get(BASE_URL);
    }

    @AfterMethod
    public void driverDestroy() {
        tearDown();
    }

    @Description("Check log-inning into the ukr net post account")
    @Test
    @TmsLink("1")
    public void logInUkrNetPostAccount() {
        UkrNetMainPage pageUkr = new UkrNetMainPage(driver);
        pageUkr.switchToLoginIframe();
        pageUkr.inputLoginInLoginField();
        pageUkr.inputPasswordInPasswordField();
        pageUkr.leftMouseClickOnButtonIn();
        pageUkr.checkUserName();
    }
}


