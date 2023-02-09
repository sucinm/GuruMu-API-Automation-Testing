package starter.GuruMu.StepDef.JadwalGuru;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.JadwalGuruAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GetSesiGuruStepDef
{
    @Steps
    JadwalGuruAPI jadwalGuruAPI;
    Authorization authorization = new Authorization();

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

    @Given("Get sesi guru with valid token and valid form-data")
    public void getSesiGuruWithValidTokenAndValidFormData() {
        jadwalGuruAPI.setGetAllSesi(authorization.getToken(), getFormValidParamsMap());
    }

    @When("Get sesi guru request")
    public void getSesiGuruRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SESI);
    }

    @Given("Get sesi guru without form-data and valid bearer")
    public void getSesiGuruWihoutFormAndValidBearer() {
        jadwalGuruAPI.setGetAllSesiWihoutForm(authorization.getToken());
    }

    private Map<String, String> getFormValidParamsMap() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("role", "guru");
        formParams.put("status", "selesai");
        return formParams;
    }

}
