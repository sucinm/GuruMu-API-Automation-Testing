package starter.GuruMu.StepDef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.LoginAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostLoginStepDef {
    @Steps
    LoginAPI loginAPI;

    @Given("Post user login with valid User")
    public void postLoginValidUser(){
        File json = new File(Constant.JSON_REQUEST+"/Login/LoginValid.json");
        loginAPI.postLogin(json);
    }

    @Given("Post user login with invalid User")
    public void postLoginInvalidUser(){
        File json = new File(Constant.JSON_REQUEST+"/Login/LoginInvalid.json");
        loginAPI.postLogin(json);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(LoginAPI.POST_LOGIN);
    }

    @And("Response body contains email {string} and message {string}")
    public void responseBodyContainsEmailAndMessages(String email, String message) {
        SerenityRest.then()
                .body(Constant.DATA_EMAIL, equalTo(email))
                .body(Constant.MESSAGE,equalTo(message));
    }

    @And("Validate json schema Login User")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Login/PostUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
