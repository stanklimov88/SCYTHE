package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.cucumber.java.en.Given;
import util.PropsManager;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

public class BasicSteps {

    public static void setup() {
        if (Objects.equals(Configuration.baseUrl, PropsManager.Load.testProperties().getProperty("localHost"))) {
            Configuration.baseUrl = PropsManager.Load.testProperties().getProperty("baseUrl");
        }
    }

    @Given("- открываем стартовую страницу")
    public void openStartPage() {
        setup();
        open("/");
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
