package starter.GuruMu.StepDef.JadwalGuru;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.GuruAPI;
import starter.GuruMu.JadwalGuruAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostJadwalGuruStepDef
{
    @Steps
    JadwalGuruAPI jadwalGuruAPI;
    Authorization authorization = new Authorization();

    @Given("Add jadwal guru with valid json and token")
    public void addJadwalGuruWithValidJsonAndToken()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuru.json");
        jadwalGuruAPI.postPostJadwalGuru(json, authorization.getTokenGuruGet());
    }

    @Given("Add jadwal guru with valid json")
    public void addJadwalGuruWithValidJson()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuru.json");
        jadwalGuruAPI.postPostJadwalGuru(json, "");
    }

    @When("Post jadwal guru request")
    public void postJadwalGuruRequest()
    {
        SerenityRest.when().post(JadwalGuruAPI.POST_JADWAL_GURU);
    }

    @And("Response body data name should contain {string} and {string}")
    public void responseBodyDataNameShouldContainAnd(String tanggal, String jam)
    {
        SerenityRest.then()
                .body(Constant.DATA_TANGGAL, equalTo(tanggal))
                .body(Constant.DATA_JAM, equalTo(jam));
    }

    @Given("Add jadwal guru with invalid json body name")
    public void addJadwalGuruWithInvalidJsonBodyName()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuruInvalid.json");
        jadwalGuruAPI.postPostJadwalGuru(json, authorization.getTokenGuru());
    }

    @Given("Add jadwal guru with invalid json body with extra category")
    public void addJadwalGuruWithInvalidJsonBodyExtraCategory()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuruExtra.json");
        jadwalGuruAPI.postPostJadwalGuru(json, authorization.getTokenGuru());
    }

    @Given("Add jadwal guru with invalid json body with blank tanggal")
    public void addJadwalGuruWithInvalidJsonBodyBlankTanggal()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuruBlankJadwal.json");
        jadwalGuruAPI.postPostJadwalGuru(json, authorization.getTokenGuru());
    }

    @Given("Add jadwal guru with invalid json body with blank jam")
    public void addJadwalGuruWithInvalidJsonBodyBlankJam()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuruBlankJam.json");
        jadwalGuruAPI.postPostJadwalGuru(json, authorization.getTokenGuru());
    }

    @And("Guru already login without bearer token")
    public void guruAlreadyLoginWithoutBearerToken()
    {
        jadwalGuruAPI.setGetAllSesiWihoutForm(Authorization.EXPIRED_TOKEN);
    }

    @Given("Add jadwal guru with invalid json body missing category")
    public void addJadwalGuruWithInvalidJsonBodyMissingCategory()
    {
        File json = new File(Constant.JSON_REQUEST + "/JadwalGuru/AddJadwalGuruMissing.json");
        jadwalGuruAPI.postPostJadwalGuru(json, authorization.getTokenGuru());
    }
}
