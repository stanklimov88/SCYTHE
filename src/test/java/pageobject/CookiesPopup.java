package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CookiesPopup {

    public static SelenideElement cookiesPopup() {
        return $x("//*[@data-id='popup']//b[contains(text(),cookie)]");
    }

    public static SelenideElement acceptAllCookiesButton() {
        return $x("//*[@data-id='popup']//button[@data-id='button-all']");
    }
}
