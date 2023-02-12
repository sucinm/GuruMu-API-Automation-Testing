package starter.GuruMu.StepDef.Guru;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;
import starter.GuruMu.Utils.Payload;

public class DeleteGuruStepDef {
    @Steps
    GuruAPI guruAPI;
    Authorization authorization = new Authorization();
    Payload payload = new Payload();

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

    @Given("Delete single data guru with {string} as email and {string} as password")
    public void deleteSingleDataGuruWithAsEmailAndAsPassword(String email, String password) {
        String token = authorization.getTokenByCustom(payload.bodyRequestLogin(email, password));
        guruAPI.deleteGuru(token);
    }
}
