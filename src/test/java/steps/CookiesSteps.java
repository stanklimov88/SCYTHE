package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static pageobject.CookiesPopup.*;

public class CookiesSteps {

    @Given("- принимаем все куки")
    public static void acceptingAllCookies() {
        acceptAllCookiesButton().click();
    }

    @Then("показан попап cookie-policy")
    public static void cookiesPopupShown() {
        cookiesPopup().shouldBe(visible);
    }

    @Then("скрыт попап cookie-policy")
    public static void cookiesPopupHidden() {
        cookiesPopup().shouldBe(hidden);
    }

    @Then("попап cookie-policy не появляется")
    public static void cookiesPopupDoesNotAppear() {
        cookiesPopup().shouldNotBe(visible, Duration.ofSeconds(3));
        cookiesPopup().shouldNotBe(interactable);
    }
}
