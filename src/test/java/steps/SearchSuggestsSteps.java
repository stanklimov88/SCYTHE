package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static util.PropertyLoader.loadProperties;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static pageobject.SearchPage.*;
import static pageobject.SearchPage.suggestsPopup;

public class SearchSuggestsSteps {

    @Given("показаны поисковые подсказки")
    public void searchSuggestsShown() {
        suggestsPopup().shouldBe(visible);
        suggests().shouldHave(sizeGreaterThan(0));
        suggests().shouldHave(sizeLessThanOrEqual(5));
    }

    @When("- кликаем на подсказку")
    public void clickOnSearchSuggest() {
        suggestItem().click();
    }

    @When("- наводим курсор на подсказку")
    public void hoverOnSearchSuggest() {
        suggestItem().hover();
    }

    @When("- кликаем на стрелку в поисковой подсказке")
    public void clickOnSearchSuggestArrow() {
        suggestItemArrow().click();
    }

    @When("- наводим курсор на стрелку в поисковой подсказке")
    public void hoverOnSearchSuggestArrow() {
        suggestItemArrow().hover();
    }

    @Then("подсказка выделена")
    public void searchSuggestHovered() {
        suggestItem().shouldHave(attribute("aria-selected", "true"));
    }

    @Then("стрелка подсказки выделена")
    public void searchSuggestArrowHovered() {
        suggestItemArrow().shouldHave(cssValue(".mini-suggest__item-button:hover", ""));
    }

    @When("- кликаем мимо подсказок")
    public void misclickSearchSuggests() {
        // TODO придумать более изящный способ мискликнуть по подсказкам
        someButton().click();
    }

    @Then("скрыты поисковые подсказки")
    public void searchSuggestsHidden() {
        suggestsPopup().shouldNotBe(visible);
    }

    @Then("- подсказка подставлена в поисковую строку")
    public void suggestTypedIntoSearchInput() {
        String queryText = loadProperties().getProperty("testSearchQuery");
        searchInput().shouldHave(partialValue(queryText));
        searchInput().shouldNotHave(exactValue(queryText));
    }
}
