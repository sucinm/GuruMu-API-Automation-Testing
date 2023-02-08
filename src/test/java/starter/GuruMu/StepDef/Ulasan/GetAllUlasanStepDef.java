package starter.GuruMu.StepDef.Ulasan;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.UlasanAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class GetAllUlasanStepDef {
    @Steps
    UlasanAPI ulasanAPI;

    @Given("Get all data ulasan with {string} as path")
    public void getAllDataUlasanWithAsPath(String path) {
        ulasanAPI.getAllDataUlasan(path);
    }

    @When("Get all ulasan request")
    public void getAllUlasanRequest() {
        SerenityRest.when().get(UlasanAPI.GET_ALL_ULASAN);
    }

    @And("Validate json schema all data ulasan")
    public void validateJsonSchemaAllDataUlasan() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Ulasan/ResponseGetAllUlasan.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
