package test;

import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import static data.YandexConstants.BASE_URL;

public class YandexTest1 extends BaseTest {
    @BeforeMethod
    public void openSite() {
        setUp().get(BASE_URL);
    }

    @AfterMethod
    public void driverDestroy() {
        tearDown();
    }

    @Description("Check log-inning into the andersentester post")
    @Test
    @TmsLink("1")
    public void logInPostAccount() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexAuthorizationsPage yandexAuthorizationsPage = new YandexAuthorizationsPage(driver);
        YandexMailPage yandexMailPage = new YandexMailPage(driver);

        yandexMainPage.clicktLinkToPostLeftMouseClick();
//        yandexAuthorizationsPage.findToLoginForm();
//        yandexAuthorizationsPage.switchToLoginForm();
        yandexAuthorizationsPage.getLoginInputField();
//        yandexAuthorizationsPage.putLoginInput();
//        yandexAuthorizationsPage.leftMouseClickOnButtonIn();
//        yandexAuthorizationsPage.putPasswordInput();
//        yandexAuthorizationsPage.leftMouseClickOnButtonIn();
//        yandexMailPage.checkUserName();
    }

}
