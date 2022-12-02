package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ErrorPage {

    public static SelenideElement error404() {
        return $x("paste here valid locator");
    }

    public static SelenideElement error500() {
        return $x("paste here valid locator");
    }
}