package starter.GuruMu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class ReservasiAPI {

    public static String POST_RESERVASI = Constant.BASE_URL + "/reservasi";

    @Step("Add Reservasi with valid/invalid json")
    public void postReservasi(File json, String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(json);
    }
}
