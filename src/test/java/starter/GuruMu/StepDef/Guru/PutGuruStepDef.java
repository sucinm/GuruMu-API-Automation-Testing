package starter.GuruMu.StepDef.Guru;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.Utils.Authorization;

import java.util.HashMap;
import java.util.Map;

public class PutGuruStepDef {
    @Steps
    GuruAPI guruAPI;
    Authorization authorization = new Authorization();

    @Given("Update guru with valid token and valid form-data")
    public void updateGuruWithValidTokenAndValidFormData() {
        guruAPI.putGuru(authorization.getToken(), getFormValidParamsMap());
    }

    @When("Put guru request")
    public void putGuruRequest() {
        SerenityRest.when().put(GuruAPI.PUT_GURU);
    }

    @Given("Update guru with expired token and valid form-data")
    public void updateGuruWithExpiredTokenAndValidFormData() {
        guruAPI.putGuru(Authorization.EXPIRED_TOKEN, getFormValidParamsMap());
    }

    @Given("Update guru with expired token and invalid form-data")
    public void updateGuruWithExpiredTokenAndInvalidFormData() {
        guruAPI.putGuru(Authorization.EXPIRED_TOKEN, getFormInvalidParamsMap());
    }

    @Given("Update guru without token and valid form-data")
    public void updateGuruWithoutTokenAndValidFormData() {
        guruAPI.putGuru(getFormValidParamsMap());
    }

    @Given("Update guru without token and invalid form-data")
    public void updateGuruWithoutTokenAndInvalidFormData() {
        guruAPI.putGuru(getFormInvalidParamsMap());
    }

    @Given("Update guru with valid token and without form-data")
    public void updateGuruWithValidTokenAndWithoutFormData() {
        guruAPI.putGuru(authorization.getToken());
    }

    @Given("Update guru with expired token and without form-data")
    public void updateGuruWithExpiredTokenAndWithoutFormData() {
        guruAPI.putGuru(Authorization.EXPIRED_TOKEN);
    }

    @Given("Update guru without token and without form-data")
    public void updateGuruWithoutTokenAndWithoutFormData() {
        guruAPI.putGuru();
    }

    private Map<String, String> getFormValidParamsMap() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("nama", "suci");
        formParams.put("email", "suci@gmail.com");
        formParams.put("alamat", "jalan suci");
        formParams.put("telefon", "08121122112");
        formParams.put("deskripsi", "saya guru baru");
        formParams.put("ijazah", "08434243123");
        formParams.put("pelajaran", "matematika");
        formParams.put("avatar", "suci.png");
        return formParams;
    }

    private Map<String, String> getFormInvalidParamsMap() {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("nama_guru", "suci");
        formParams.put("email", "suci@gmail.com");
        formParams.put("alamat", "jalan suci");
        formParams.put("telefon", "08121122112");
        formParams.put("deskripsi", "saya guru baru");
        formParams.put("ijazah", "08434243123");
        formParams.put("pelajaran", "matematika");
        formParams.put("avatar", "suci.png");
        return formParams;
    }
}
