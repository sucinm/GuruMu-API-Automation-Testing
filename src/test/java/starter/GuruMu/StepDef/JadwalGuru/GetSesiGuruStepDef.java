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

    @Given("Get all data sesi guru with role as {string} and status as {string}")
    public void getAllDataSesiGuruValidWithAsPath(String role, String status)
    {
        jadwalGuruAPI.getAllDataSesiGuruWithRoleAndStatus(role, status);
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

    @When("Get sesi guru request")
    public void getSesiGuruRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SESI_VALID);
    }

    @And("Guru already login with valid account")
    public void guruAlreadyLoginWithValidAccount()
    {
        jadwalGuruAPI.setGetAllSesiWihoutForm(authorization.getTokenGuruGet());
    }

    @When("Get sesi guru without param request")
    public void getSesiGuruWithoutParamRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SESI_WITHOUT_PARAM);
    }

    @When("Get sesi guru without parameter request")
    public void getSesiGuruWithoutParameterRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_ALL_SESI_PATH);
    }

    @When("Get sesi guru with invalid param request")
    public void getSesiGuruWithInvalidParamRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SESI_INVALID_PARAM);
    }

    @When("Get sesi guru with invalid param data type request")
    public void getSesiGuruWithInvalidParamDataTypeRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_ALL_SESI);
    }

    @When("Get sesi guru with invalid param missing category request")
    public void getSesiGuruWithInvalidParamMissingRequest()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SESI_MISSING_CATEGORY);
    }
}
