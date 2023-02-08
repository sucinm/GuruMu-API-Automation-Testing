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

public class GetUlasanStepDef {

    @Steps
    UlasanAPI ulasanAPI;

    @Given("Get single data ulasan with {int} as ID")
    public void getSingleDataUlasanWithAsID(int id) {
        ulasanAPI.getSingleDataUlasan(id);
    }

    @And("Validate json schema single data ulasan")
    public void validateJsonSchemaSingleDataUlasan() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Ulasan/ResponseGetUlasan.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Get ulasan request")
    public void getUlasanRequest() {
        SerenityRest.when().get(UlasanAPI.GET_ULASAN_BY_ID);
    }

    @Given("Get single data ulasan with {string} as ID")
    public void getSingleDataUlasanWithAsID(String id) {
        ulasanAPI.getSingleDataUlasan(id);
    }
}
