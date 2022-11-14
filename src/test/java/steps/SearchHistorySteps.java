package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static util.PropertyLoader.loadProperties;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static pageobject.SearchPage.*;
import static pageobject.SearchSettingsPage.header;
import static steps.SearchSteps.*;

public class SearchHistorySteps {

    @Given("открыта страница настройки поиска")
    public void searchSettingsPageOpen() {
        header().shouldBe(visible);
    }

    @When("- вызываем историю поиска")
    public void openSearchHistory() {
        openSearchPage();
        clickOnSearchInput();
    }

    @Given("- заполняем поисковую историю")
    public void populateSearchHistory() {
        clickOnSearchInput();
        if(historyItems().size() < 5) {
            fillSearchHistory();
        }
    }

    @When("- выполняем серию поисковых запросов")
    public void fillSearchHistory() {
        searching(5);
    }

    @When("- кликаем по запросу в истории")
    public void clickingSearchHistoryItem() {
        historyItems().first().click();
    }

    @When("- удаляем запрос из истории")
    public void deleteTopHistoryItem() {
        historyItemDeleteButton().click();
    }

    @When("- удаляем все запросы из истории")
    public void deleteAllHistoryItems() {
        while(historyItems().size() > 0) {
            if (historyItems().size() == 1 && settingsItem().isDisplayed()) {
                break;
            } else {
                deleteTopHistoryItem();
            }
        }
    }

    @Then("отображается поисковая история")
    public void historyPopupShown() {
        suggestsPopup().shouldBe(visible);
        historyItems().shouldHave(sizeGreaterThan(0));
        historyItems().shouldHave(sizeLessThanOrEqual(5));
    }

    @When("проверочный запрос в истории отображается верхним")
    public void lastQueryIsOnTop() {
        historyItem().shouldHave(
                text(loadProperties().getProperty("testSearchQuery"))
        );
    }

    @Then("история поиска отсутствует")
    public void historyPopupHidden() {
        historyItems().first().shouldBe(hidden);
    }

    @Then("- кликаем по ссылке настроек истории")
    public void clickSearchSettingsLink() {
        searchSettingsLink().click();
    }
}
