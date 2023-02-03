package starter.GuruMu.StepDef.Guru;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class GetGuruStepDef {

    @Steps
    GuruAPI guruAPI;

    @Given("Get single data guru with {int} as ID")
    public void getSingleDataGuruWithAsID(int id) {
        guruAPI.getSingleDataGuru(id);
    }

    @And("Validate json schema single data guru")
    public void validateJsonSchemaSingleDataGuru() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Guru/ResponseGetGuru.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Get guru request")
    public void getGuruRequest() {
        SerenityRest.when().get(GuruAPI.GET_GURU_BY_ID);
    }

    @Given("Get single data guru with {string} as ID")
    public void getSingleDataGuruWithAsID(String id) {
        guruAPI.getSingleDataGuru(id);
    }
}
