package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import util.PropsManager;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static util.DataGenerator.generateLiteralCyrillicString;
import static pageobject.SearchPage.*;
import static pageobject.SearchResultsPage.*;
import static pageobject.OnscreenKeyboardPopup.*;
import static steps.BasicSteps.setup;

public class SearchSteps {

    @Given("- открываем страницу поиска")
    public static void openSearchPage() {
        setup();
        open("/");
    }

    @When("- кликаем в поисковую строку")
    public static void clickOnSearchInput() {
        searchInput().click();
    }

    @Then("отображается поисковая строка")
    public void searchInputShown() {
        searchInput().shouldBe(visible);
    }

    @When("- вводим проверочный поисковой запрос")
    public static void typingSearchQuery() {
        searchInput().setValue(PropsManager.Load.testProperties().getProperty("testSearchQuery"));
    }

    @When("- вводим рандомный текст в поисковую строку")
    public void typeRandomText() {
        searchInput().setValue(generateLiteralCyrillicString(10));
    }

    @When("- вводим {string} в поисковую строку")
    public static void typingSearchQuery(String query) {
        searchInput().setValue(query);
    }

    @When("- очищаем строку поиска")
    public void clearSearchInput() {
        clearButton().click();
    }

    @When("- отправляем запрос")
    public void sendSearchRequest() {
        sendRequestButton().click();
    }

    @When("- отправляем проверочный запрос")
    public static void searching() {
        typingSearchQuery();
        sendRequestButton().click();
    }

    public static void searching(int times) {
        for (int i=1; i<=times; i++) {
            searching(i + " potato");
            openSearchPage();
        }
    }

    @When("- ищем по запросу {string}")
    public static void searching(String query) {
        if (query.equals("")) {
            searching();
        } else {
            typingSearchQuery(query);
            sendRequestButton().click();
        }
    }

    @Then("очищена строка поиска")
    public void searchInputCleared() {
        searchInput().shouldBe(empty);
    }

    @Then("показаны результаты поиска")
    public void searchResultsShown() {
        searchResultSnippet().should(exist);
    }

    @Then("нет результатов поиска")
    public void searchResultsHidden() { searchResultSnippet().shouldNot(exist); }

    @Then("показана заглушка отсутствия результатов поиска")
    public void emptyResultsStubShown() {
        emptyResultsStub().shouldBe(visible);
    }

    @Then("скрыта экранная клавиатура")
    public void onscreenKeyboardHidden() {
        onscreenKeyboardPopup().shouldNotBe(visible);
    }

    @Then("показана экранная клавиатура")
    public void onscreenKeyboardShown() {
        onscreenKeyboardPopup().shouldBe(visible);
    }

    @Then("скрыта иконка вызова экранной клавиатуры")
    public void keyboardIconHidden() {
        keyboardIcon().shouldNotBe(visible);
    }

    @Then("показана иконка вызова экранной клавиатуры")
    public void keyboardIconShown() {
        keyboardIcon().shouldBe(visible);
    }

    @When("- нажимаем иконку вызова экранной клавиатуры")
    public void clickingKeyboardIcon() {
        keyboardIcon().click();
    }

    @When("- нажимаем крестик закрытия экранной клавиатуры")
    public void clickingCloseKeyboardButton() {
        closeKeyboardButton().click();
    }

    @When("- открываем экранную клавиатуру")
    public void openOnscreenKeyboard() {
        if(!onscreenKeyboardPopup().isDisplayed()) {
            clickOnSearchInput();
            clickingKeyboardIcon();
        }
    }
}
