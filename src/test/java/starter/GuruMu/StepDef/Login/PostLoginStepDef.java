package starter.GuruMu.StepDef.Login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.LoginAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class PostLoginStepDef {
    @Steps
    LoginAPI loginAPI;

    @Given("Post user login with valid Teacher")
    public void postLoginValidUser(){
        File json = new File(Constant.JSON_REQUEST+"/Login/LoginValid.json");
        loginAPI.postLogin(json);
    }

    @Given("Post user login with valid Student")
    public void postLoginValidUserStudent(){
        File json = new File(Constant.JSON_REQUEST+"/Login/LoginValidMurid.json");
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
                .body(Constant.MESSAGE, equalTo(message));
    }

    @And("Validate json schema Guru Login")
    public void validateJsonSchemaGuruLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Login/PostUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }


    @Given("Post user login with empty json")
    public void postUserLoginWithEmptyJson() {
        File json = new File(Constant.JSON_REQUEST+"/Login/EmptyLogin.json");
        loginAPI.postLogin(json);
    }

    @Given("Post user login with invalid json format")
    public void postUserLoginWithInvalidJsonFormat() {
        File json = new File(Constant.JSON_REQUEST+"/Login/InvalidFormat.json");
        loginAPI.postLogin(json);
    }

    @Given("Post user login with invalid json key")
    public void postUserLoginWithInvalidJsonKey() {
        File json = new File(Constant.JSON_REQUEST+"/Login/InvalidKey.json");
        loginAPI.postLogin(json);
    }

    @When("Send request login user with invalid path")
    public void sendRequestLoginUserWithInvalidPath() {
        SerenityRest.when().post(LoginAPI.INVALID_PATH_LOGIN);
    }

    @And("Validate json schema student Login")
    public void validateJsonSchemaStudentLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Login/PostMuridSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post user login with valid User")
    public void postUserLoginWithValidUser() {
        File json = new File(Constant.JSON_REQUEST+"/Login/LoginValid.json");
        loginAPI.postLogin(json);
    }

    @And("Validate json schema Login User")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/Login/PostMuridSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
