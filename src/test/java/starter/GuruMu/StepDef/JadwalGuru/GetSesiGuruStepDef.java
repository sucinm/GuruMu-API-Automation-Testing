package starter.GuruMu.StepDef.JadwalGuru;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.JadwalGuruAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class GetSesiGuruStepDef
{
    @Steps
    JadwalGuruAPI jadwalGuruAPI;

    @Given("Get all data sesi guru with {string} as path")
    public void getAllDataSesiGuruWithAsPath(String path)
    {
        jadwalGuruAPI.getAllDataSesiGuru(path);
    }

    @When("Get all sesi guru request")
    public void getAllSesiGuruRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_ALL_SESI);
    }

    @And("Validate json schema all data sesi guru")
    public void validateJsonSchemaAllDataSesiGuru()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/JadwalGuru/ResponseGetAllSesiGuru.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
