package pages;

import core.ActionByActions;
import core.ClickOn;
import core.Helper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class YandexMarketPage extends PageObjectCreator implements ClickOn, ActionByActions, Helper {

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(@aria-label, 'сравнению')]")
    WebElement foundedComparisonButtons;

    @FindBy(xpath = "//a[contains(@href,'product')]")
    List<WebElement> comparedItems;

    @FindBy(partialLinkText = "Сравнить")
    WebElement compareButton;

    @FindBy(xpath = "//button[text()='Удалить список']")
    WebElement deleteButton;

    @FindBy(className = "_2szVRO2K75")
    WebElement nothingToCompareWarning;

    public List<WebElement> foundedItems(String description) {
        return driver.findElements(By.xpath("//a[contains(@href, '/product') and contains(@title,'" + description +
                "')]"));
    }

    public boolean itemsArePresent(WebDriver driver, List<String> findUs) {
        boolean flag = false;
        for (String elementAnnotation : findUs) {
            try {
                flag = true;
                driver.findElement(By.partialLinkText(elementAnnotation));
            } catch (NoSuchElementException e) {
                flag = false;
            }
        }
        return flag;
    }

    @Step("put some data into the search field")
    public void putWordInSearchField(String searchText) {
        putTextIntoField(searchField, searchText);
    }

    @Step("click on the submit button ")
    public void clickOnSubmitButton() {
        clickOnMouse(submitButton);
    }

    @Step("put a number of first items to comparison")
    public List<String> getListItemsForComparison(int number, String description) {
        ArrayList<String> selectedFor = new ArrayList<>();
        List<WebElement> foundedItems = foundedItems(description);
        for (int i = 0; i < number; i++) {
            hoverMouseAboveElement(driver, foundedItems.get(i));
            selectedFor.add(getElementValue(foundedItems.get(i)));
            clickOnMouse(foundedComparisonButtons);
        }
        return selectedFor;
    }

    @Step("click on the compare button ")
    public void clickOnCompareButton() {
        clickOnMouse(compareButton);
    }

    @Step("build a list of compared items")
    public List<String> getListComparedItems(int number) {
        List<String> justCompared = new ArrayList<>();

        new WebDriverWait(driver, 20).
                withMessage("selected items are not present").
                until(ExpectedConditions.visibilityOfAllElements(comparedItems));
        for (int i = 0; i < number; i++)
            justCompared.add(getElementValue(comparedItems.get(i)));
        return justCompared;
    }

    @Step("compare  if compared items are the same, as selected")
    public void checkComparedItems(List<String> selected, List<String> compared) {
        Assert.assertTrue((selected.containsAll(compared) && compared.containsAll(selected) && selected.size() ==
                compared.size()), "some items are different");
    }

    @Step("delete selected items from comparison")
    public void deleteFromComparison() {
        clickOnMouse(deleteButton);
    }

    @Step("check if the items are removed from comparison")
    public void checkIfRemoved(List<String> listString) {
        SoftAssert verySoftAssert = new SoftAssert();
        verySoftAssert.assertTrue(nothingToCompareWarning.isDisplayed() && getElementValue(nothingToCompareWarning).
                matches("Сравнивать пока нечего"), "the compared list is not empty");
        verySoftAssert.assertFalse(itemsArePresent(driver, listString));
        verySoftAssert.assertAll();
    }
}