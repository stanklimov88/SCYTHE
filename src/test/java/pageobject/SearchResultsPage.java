package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {

    public static SelenideElement searchResultSnippet() {
        return $x("//*[@class='serp-item serp-item_card']");
    }

    public static SelenideElement emptyResultsStub() {
        return $x("//div[text()='По вашему запросу ничего не нашлось']");
    }
}
