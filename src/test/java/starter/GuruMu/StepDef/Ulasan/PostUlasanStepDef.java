package starter.GuruMu.StepDef.Ulasan;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.UlasanAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostUlasanStepDef {
    @Steps
    UlasanAPI ulasanAPI;

    @Given("Add ulasan with valid json and {int} as ID")
    public void addUlasanWithValidJson(int id) {
        File json = new File(Constant.JSON_REQUEST + "/Ulasan/AddUlasan.json");
        ulasanAPI.postUlasan(json, id);
    }

    @Given("Add ulasan with invalid json and {int} as ID")
    public void addUlasanWithInvalidJson(int id) {
        File json = new File(Constant.JSON_REQUEST + "/Ulasan/AddInvalidUlasan.json");
        ulasanAPI.postUlasan(json, id);
    }

    @Given("Add ulasan with valid json without ID guru")
    public void addUlasanWithWithoutIDUlasan() {
        File json = new File(Constant.JSON_REQUEST + "/Ulasan/AddUlasan.json");
        ulasanAPI.postUlasan(json);
    }

    @When("Post ulasan request")
    public void postUlasanRequest() {
        SerenityRest.when().post(UlasanAPI.POST_ULASAN);
    }
}
