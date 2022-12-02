package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import util.PropsManager;

import java.util.Objects;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static pageobject.ErrorPage.error404;
import static pageobject.ErrorPage.error500;

public class BasicSteps {

    public static void setup() {
        if (Objects.equals(Configuration.baseUrl, PropsManager.Load.testProperties().getProperty("localHost"))) {
            Configuration.baseUrl = PropsManager.Load.testProperties().getProperty("baseUrl");
        }
    }

    public static void setRemote() {
        Configuration.remote = "http://localhost:4444/";
    }

    @Given("- открываем стартовую страницу")
    public void openStartPage() {
        setup();
        open("/");
        // enable this line to check for errors
        //checkErrors();
    }

    public void checkErrors() {
        // adjust errors for checking by commenting this lines
        not404();
        not500();
    }

    @Then("нет ошибки 500")
    public void not500() {
        error500().shouldNot(exist);
    }

    @Then("нет ошибки 404")
    public void not404() {
        error404().shouldNot(exist);
    }

    @Given("- обновляем страницу")
    public static void refreshPage() {
        Selenide.refresh();
    }

    @Given("- очищаем куки")
    public static void clearCookies() {
        clearBrowserCookies();
    }
}
