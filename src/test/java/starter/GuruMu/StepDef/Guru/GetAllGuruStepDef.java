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

import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllGuruStepDef {
    @Steps
    GuruAPI guruAPI;

    @Given("Get all data guru with {string} as path")
    public void getAllDataGuruWithAsPath(String path)
    {
        guruAPI.getAllDataGuru(path);
    }

    @When("Get all guru request")
    public void getAllGuruRequest()
    {
        SerenityRest.when().get(GuruAPI.GET_ALL_GURU);
    }

    @And("Validate json schema all data guru")
    public void validateJsonSchemaAllDataGuru()
    {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Guru/ResponseGetAllGuru.json");
        SerenityRest.then()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get all data guru with {string} as path in page {string}")
    public void getAllDataGuruWithAsPathInPage(String path, String page) {
        guruAPI.getAllDataGuru(path, page);
    }

    @And("Validate pagination page is {string}")
    public void validatePaginationPageIs(String page) {
        SerenityRest.then()
                .body(Constant.PAGINATION_PAGE, equalTo(page));
    }
}
