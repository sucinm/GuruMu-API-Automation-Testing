package starter.GuruMu.StepDef.Guru;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Payload;

import java.util.HashMap;
import java.util.Map;

public class PutGuruStepDef {
    @Steps
    GuruAPI guruAPI;
    Authorization authorization = new Authorization();
    Payload payload = new Payload();
    @Given("Update guru with {string} as nama, {string} as email, and {string} as password")
    public void updateGuruWithAsNamaAsEmailAndAsPassword(String nama, String email, String password) {
        String token = authorization.getTokenByCustom(payload.bodyRequestLogin(email, password));
        guruAPI.putGuru(token, getFormValidParamsMap(nama, email, password));
    }

    @When("Put guru request")
    public void putGuruRequest() {
        SerenityRest.when().put(GuruAPI.PUT_GURU);
    }

    @Given("Update guru with expired token and without form-data")
    public void updateGuruWithExpiredTokenAndWithoutFormData() {
        guruAPI.putGuru(Authorization.EXPIRED_TOKEN);
    }

    @Given("Update guru without token and without form-data")
    public void updateGuruWithoutTokenAndWithoutFormData() {
        guruAPI.putGuru();
    }

    private Map<String, String> getFormValidParamsMap(String nama, String email, String password) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("nama", nama);
        formParams.put("email", email);
        formParams.put("password", password);
        formParams.put("ijazah", "file.png");
        formParams.put("tarif", "50000");
        formParams.put("telepon", "0912345352");
        formParams.put("latitude", "-6.347891");
        formParams.put("longitude", "106.741158");
        formParams.put("lokasi_asal", "Jakarta");
        formParams.put("tentang_saya", "saya masih baru");
        formParams.put("pengalaman", "belum ada");
        formParams.put("metode_belajar", "online");
        formParams.put("avatar", "file.jpg");
        formParams.put("linkedin", "linkedin/test");
        formParams.put("pelajaran", "matematika");
        formParams.put("pendidikan", "S1");
        formParams.put("gelar", "SST");
        return formParams;
    }

    private Map<String, String> getFormInValidParamsMap(String nama, String email, String password) {
        Map<String, String> formParams = new HashMap<>();
        formParams.put("nama_guru", nama);
        formParams.put("email", email);
        formParams.put("password", password);
        formParams.put("ijazah", "file.png");
        formParams.put("tarif", "50000");
        formParams.put("telepon", "0912345352");
        formParams.put("latitude", "-6.347891");
        formParams.put("longitude", "106.741158");
        formParams.put("lokasi_asal", "Jakarta");
        formParams.put("tentang_saya", "saya masih baru");
        formParams.put("pengalaman", "belum ada");
        formParams.put("metode_belajar", "online");
        formParams.put("avatar", "file.jpg");
        formParams.put("linkedin", "linkedin/test");
        formParams.put("pelajaran", "matematika");
        formParams.put("pendidikan", "S1");
        formParams.put("gelar", "SST");
        return formParams;
    }
    @Given("Update guru with {string} as nama, {string} as email, and {string} as password with expired token")
    public void updateGuruWithAsNamaAsEmailAndAsPasswordWithExpiredToken(String nama, String email, String password) {
        guruAPI.putGuru(Authorization.EXPIRED_TOKEN, getFormValidParamsMap(nama, email, password));
    }
    @Given("Update guru with {string} as nama, {string} as email, and {string} as password with expired token and invalid form-data")
    public void updateGuruWithAsNamaAsEmailAndAsPasswordWithExpiredTokenAndInvalidFormData(String nama, String email, String password) {
        guruAPI.putGuru(Authorization.EXPIRED_TOKEN, getFormInValidParamsMap(nama, email, password));
    }
    @Given("Update guru with {string} as nama, {string} as email, and {string} as password without token and valid form-data")
    public void updateGuruWithAsNamaAsEmailAndAsPasswordWithoutTokenAndValidFormData(String nama, String email, String password) {
        guruAPI.putGuru(getFormValidParamsMap(nama, email, password));
    }
    @Given("Update guru with {string} as nama, {string} as email, and {string} as password with valid token and without form-data")
    public void updateGuruWithAsNamaAsEmailAndAsPasswordWithValidTokenAndWithoutFormData(String nama, String email, String password) {
        String token = authorization.getTokenByCustom(payload.bodyRequestLogin(email, password));
        guruAPI.putGuru(token);
    }
}
