package steps;

import io.cucumber.java.en.Given;
import io.restassured.specification.RequestSpecification;
import util.PropsManager;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiSteps {

    public RequestSpecification useBaseURI() {
        return given().baseUri(PropsManager.Load.testProperties().getProperty("apiUri"));
    }

    @Given("- вызываем API")
    public void callApiEndpoint() {
        useBaseURI().get("posts/1");
    }

    @Given("- вызывае API и проверяем ответ")
    public void callApiEndpointAndAssertResponse() {
        useBaseURI().
                when().
                    get("posts/1").
                then().
                    body("id", equalTo(1));
    }
}
