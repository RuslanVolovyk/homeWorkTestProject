package pages;

import core.ClickOn;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class YandexLanguagePage extends PageObjectCreator implements ClickOn {
    public YandexLanguagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button")
    WebElement languageButton;

    @FindBy(css = "div:nth-of-type(6) > .select__text")
    WebElement englishButton;

    @FindBy(className = "form__save")
    WebElement saveButton;

    @FindBy(tagName = "html")
    WebElement htmlAttribute;

    @Step("clicking on the language button on the interface page")
    public void clickOnLanguageButton() {
        clickOnMouse(languageButton);
    }

    @Step("select English language on the interface page")
    public void selectEnglish() {
        clickOnMouse(englishButton);
    }

    @Step("clicking on the save button")
    public void clickSaveButton() {
        clickOnMouse(saveButton);
    }

    @Step("check the interface language")
    public void checkInterfaceLanguage() {
        Assert.assertTrue(getElementValue(htmlAttribute).contains("English"),
                "the interface language is not English");
    }
}