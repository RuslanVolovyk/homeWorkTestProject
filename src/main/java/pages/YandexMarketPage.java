package pages;

import core.ClickOn;
import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class YandexMarketPage extends PageObjectCreator implements ClickOn {

    public YandexMarketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='header-search']")
    WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(@aria-label, 'сравнению')]")
    WebElement foundedComparisonButtons;

    @FindBy(xpath = "//a[contains(@href, '/product') and contains(@title,'Смарт')]")
    List<WebElement> foundedItems;

    @FindBy(xpath = "//a[contains(@href,'product')]")
    List<WebElement> comparedItems;

    @FindBy(partialLinkText = "Сравнить")
    WebElement compareButton;

    @Step("put Note 8 into the search field")
    public void putNote8InSearchField() {
        putTextIntoField(searchField, "Note 8");
    }

    @Step("click on the submit button ")
    public void clickOnSubmitButton() {
        clickOnMouse(submitButton);
    }

    @Step("put a number of first items to comparison")
    public ArrayList<String> putItemsToComparison(int number) {
        Actions actMouse = new Actions(driver);
        ArrayList<String> selectedFor = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            actMouse.moveToElement(foundedItems.get(i)).build().perform();
            selectedFor.add(foundedItems.get(i).getText());
            clickOnMouse(foundedComparisonButtons);
        }
        Collections.sort(selectedFor);
        return selectedFor;
    }

    @Step("click on the compare button ")
    public void clickOnCompareButton() {
        clickOnMouse(compareButton);
    }

    @Step("build a list of compared items")
    public ArrayList<String> checkComparedItems(int number) {
        ArrayList<String> justCompared = new ArrayList<>();

        new WebDriverWait(driver, 20).
                withMessage("selected items are not present").
                until(ExpectedConditions.visibilityOfAllElements(comparedItems));
        for (int i = 0; i < number; i++)
            justCompared.add(comparedItems.get(i).getText());
        Collections.sort(justCompared);
        return justCompared;
    }

    @Step("compare  if compared items are the same, as selected")
    public void checkComparedItems(ArrayList<String> selected, ArrayList<String> compared) {
        Assert.assertEquals(selected, compared, "some items are different");
    }
}
