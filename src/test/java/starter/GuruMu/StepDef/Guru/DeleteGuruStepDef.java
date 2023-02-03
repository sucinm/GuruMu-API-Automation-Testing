package starter.GuruMu.StepDef.Guru;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;

public class DeleteGuruStepDef {
    @Steps
    GuruAPI guruAPI;
    Authorization authorization = new Authorization();
    @Given("Delete single data guru with valid token")
    public void deleteSingleDataGuruWithValidToken() {
        guruAPI.deleteGuru(authorization.getToken());
    }

    @Given("Delete single data guru with expired token")
    public void deleteSingleDataGuruWithExpiredToken() {
        guruAPI.deleteGuru(Authorization.EXPIRED_TOKEN);
    }

    @Given("Delete single data guru without token")
    public void deleteSingleDataGuruWithoutToken() {
        guruAPI.deleteGuru();
    }

    @When("Delete guru request")
    public void deleteGuruRequest() {
        SerenityRest.when().delete(GuruAPI.DELETE_GURU);
    }
}
