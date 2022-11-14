package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import io.cucumber.java.en.Given;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static util.PropertyLoader.loadProperties;

public class BasicSteps {

    public static void setup() {
        if (Objects.equals(Configuration.baseUrl, loadProperties().getProperty("localHost"))) {
            Configuration.baseUrl = loadProperties().getProperty("baseUrl");
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
