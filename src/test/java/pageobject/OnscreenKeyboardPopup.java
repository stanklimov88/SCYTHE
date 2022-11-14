package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class OnscreenKeyboardPopup {

    public static SelenideElement onscreenKeyboardPopup() {
        return $(".keyboard");
    }

    public static SelenideElement keyboardIcon() {
        return $x("//*[@role='button' and @data-action='keyboard']");
    }

    public static SelenideElement closeKeyboardButton() {
        return $x("//span[@class='keyboard-popup__close']");
    }

    public static SelenideElement keyboardKey() {
        return $x("");
    }
}
