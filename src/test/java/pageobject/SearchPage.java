package pageobject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    public static SelenideElement searchInput() {
        return $(".search3__input");
    }

    public static SelenideElement sendRequestButton() {
        return $x("//button[@type='submit' and text()='Найти']");
    }

    public static SelenideElement clearButton() {
        return $(".search3__svg_clear");
    }

    public static SelenideElement suggestsPopup() {
        return $(".mini-suggest__popup");
    }

    public static ElementsCollection suggests() {
        return $$(".mini-suggest__item");
    }

    public static SelenideElement suggestItem() {
        return $x("//span[contains(@class,'mini-suggest__arrow')]//parent::li[contains(@id,'suggest-item')]");
    }

    public static SelenideElement suggestItemArrow() {
        return $x("//span[contains(@class,'mini-suggest__arrow')]");
    }

    public static SelenideElement historyItem() {
        return $x("//span[contains(@class,'mini-suggest__delete')]//parent::li[contains(@id,'suggest-item')]");
    }

    public static ElementsCollection historyItems() {
        return $$x("//span[contains(@class,'mini-suggest__delete')]//parent::li[contains(@id,'suggest-item')]");
    }

    public static SelenideElement historyItemDeleteButton() {
        return $x("//span[contains(@class,'mini-suggest__delete')]");
    }

    public static SelenideElement settingsItem() {
        return $x("//li[@data-type='history-tune']");
    }

    public static SelenideElement searchSettingsLink() {
        return $x("//a[text()='Настройки истории']");
    }

    public static SelenideElement someButton() {
        return $x("//*[@role='button']");
    }
}