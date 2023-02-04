package starter.GuruMu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GuruMu.Utils.Constant;

import java.awt.*;
import java.io.File;

public class LoginAPI {
    public static String POST_LOGIN = Constant.BASE_URL + "/login";

    @Step("Post login with valid/invalid User")
    public void postLogin(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }



}
