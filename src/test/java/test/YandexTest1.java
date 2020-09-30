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

    @Description("Check log-inning into the andersentester's post")
    @Test
    @TmsLink("1")
    public void logInPostAccount() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexAuthorizationsPage yandexAuthorizationsPage = new YandexAuthorizationsPage(driver);
        YandexMailPage yandexMailPage = new YandexMailPage(driver);

        yandexMainPage.clicktLinkToPostByMouse();
        yandexAuthorizationsPage.switchToPassportTab();
        yandexAuthorizationsPage.putLogin();
        yandexAuthorizationsPage.leftMouseClickOnButtonIn();
        yandexAuthorizationsPage.putPassword();
        yandexAuthorizationsPage.leftMouseClickOnButtonIn();
        yandexMailPage.checkUserName();
    }

    @Description("Check log-inning and log-out the andersentester's post account")
    @Test
    @TmsLink("2")
    public void logInAndOutPostAccount() {
        YandexMainPage yandexMainPage = new YandexMainPage(driver);
        YandexAuthorizationsPage yandexAuthorizationsPage = new YandexAuthorizationsPage(driver);
        YandexMailPage yandexMailPage = new YandexMailPage(driver);

        yandexMainPage.clicktLinkToPostByMouse();
        yandexAuthorizationsPage.switchToPassportTab();
        yandexAuthorizationsPage.putLogin();
        yandexAuthorizationsPage.leftMouseClickOnButtonIn();
        yandexAuthorizationsPage.putPassword();
        yandexAuthorizationsPage.leftMouseClickOnButtonIn();
        yandexMailPage.clickOnUserMenu();
        yandexMailPage.checkUserMenuVisibility();
        yandexMailPage.clickOnSignOutLink();
        yandexAuthorizationsPage.checkUrl();
    }
}
