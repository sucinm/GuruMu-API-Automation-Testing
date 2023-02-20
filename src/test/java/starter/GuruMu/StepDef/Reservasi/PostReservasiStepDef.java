package starter.GuruMu.StepDef.Reservasi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.ReservasiAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class PostReservasiStepDef {

    @Steps
    ReservasiAPI reservasiAPI;
    Authorization authorization = new Authorization();

    @Given("Lanjutkan Pembayaran with valid json")
    public void addLanjutkanPembayaranWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddReservasiCompleteBody.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());
    }

    @Given("Lanjutkan Pembayaran without pesan json")
    public void addLanjutkanPembayaranWithoutJson() throws InterruptedException {
        Thread.sleep(3000);
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddReservasiWithoutPesan.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());

    }

    @Given("Lanjutkan Pembayaran without metode belajar json")
    public void addLanjutkanPembayaranWithoutMetodeBelajarJson() {
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddReservasiWithoutMetodeBelajar.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());
    }

    @Given("Lanjutkan Pembayaran without tanggal json")
    public void addLanjutkanPembayaranWithoutTanggalJson() {
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddReservasiWithoutMetodeBelajar.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());
    }

    @Given("Lanjutkan Pembayaran without jam json")
    public void addLanjutkanPembayaranWithoutJamJson() {
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddReservasiWithoutJam.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());
    }

    @Given("Lanjutkan Pembayaran without metode pembayaran json")
    public void addLanjutkanPembayaranWithoutMetodePembayaranJson() {
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddReservasiWithoutMetodePembayaran.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());
    }

    @Given("Lanjutkan Pembayaran with invalid json")
    public void addLanjutkanPembayaranWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Reservasi/AddInvalidReservasi.json");
        reservasiAPI.postReservasi(json, authorization.getTokenSiswa());
    }

    @When("Post Reservasi request")
    public void postReservasiRequest() throws InterruptedException {
        Thread.sleep(3000);
        SerenityRest.when().post(ReservasiAPI.POST_RESERVASI);
    }

    @And("Response body data should contain 'status pembayaran' {string}")
    public void responseBodyDataShouldContainStatusPembayaran(String status_pembayaran) {
        SerenityRest.then()
                .body(Constant.DATA_STATUS, equalTo(status_pembayaran));
    }
}
