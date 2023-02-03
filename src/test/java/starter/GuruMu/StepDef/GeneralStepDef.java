package starter.GuruMu.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import starter.GuruMu.Utils.Constant;

import static org.hamcrest.CoreMatchers.equalTo;

public class GeneralStepDef {

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body message contain {string}")
    public void responseBodyMessageContain(String message) {
        SerenityRest.then()
                .body(Constant.MESSAGE, equalTo(message));
    }
}