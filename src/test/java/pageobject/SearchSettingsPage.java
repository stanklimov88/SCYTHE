package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchSettingsPage {

    public static SelenideElement header() {
        return $x("//*[@class='options__header' and text()='Настройка поиска']");
    }
}
