package starter.GuruMu.StepDef.Guru;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostGuruStepDef {
    @Steps
    GuruAPI guruAPI;

    @Given("Add guru with valid json")
    public void addGuruWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Guru/AddGuru.json");
        guruAPI.postGuru(json);
    }

    @Given("Add guru with invalid json")
    public void addGuruWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Guru/AddInvalidGuru.json");
        guruAPI.postGuru(json);
    }

    @When("Post guru request")
    public void postGuruRequest() {
        SerenityRest.when().post(GuruAPI.POST_GURU);
    }

    @And("Response body data nama should contain {string}")
    public void responseBodyDataNamaShouldContain(String name) {
        SerenityRest.then()
                .body(Constant.DATA_NAMA, equalTo(name));
    }

}
