package starter.GuruMu.StepDef.JadwalSiswa;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.JadwalGuruAPI;
import starter.GuruMu.UlasanAPI;
import starter.GuruMu.Utils.Authorization;

public class GetSesiSiswaStepDef
{
    @Steps
    JadwalGuruAPI jadwalGuruAPI;
    Authorization authorization = new Authorization();

    @Given("Get all murid session without param and bearer using path {string}")
    public void getAllSesiMuridWithoutParamAndBearer(String sesiku)
    {
        jadwalGuruAPI.getAllDataSesiGuru(sesiku);
    }


    @When("Get sesi murid without param")
    public void getSesiMuridWithoutParam()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_ALL_SESI_PATH);
    }

    @Given("Get all murid session without param and valid bearer using path {string}")
    public void getAllMuridSessionWithoutParamAndValidBearerUsingPath(String sesiku)
    {
        jadwalGuruAPI.getAllDataSesiGuru(sesiku);
    }

    @When("Get sesi murid without parameter")
    public void getSesiMuridWithoutParameter()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_ALL_SESI);
    }

    @And("Murid already login with valid account")
    public void muridAlreadyLoginWithValidAccount()
    {
        jadwalGuruAPI.setGetAllSesiWihoutForm(authorization.getTokenSiswaGet());
    }

    @When("Get sesi murid with valid param")
    public void getSesiMuridWithValidParam()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SESI_SISWA);
    }

    @When("Get sesi murid with invalid extra param")
    public void getSesiMuridWithInvalidExtraParam()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SISWA_EXTRA);
    }

    @When("Get sesi murid with invalid param data type")
    public void getSesiMuridWithInvalidParamDataType()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SISWA_TYPE);
    }

    @When("Get sesi murid with invalid param missing")
    public void getSesiMuridWithInvalidParamMissing()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SISWA_MISSING);
    }

    @When("Get sesi murid with invalid blank param")
    public void getSesiMuridWithInvalidBlankParam()
    {
        SerenityRest.when().get(JadwalGuruAPI.GET_SISWA_BLANK);
    }
}
