package starter.GuruMu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class UlasanAPI {
    public static String POST_ULASAN = Constant.BASE_URL + "/ulasan/{id}";

    public static String GET_ALL_ULASAN = Constant.BASE_URL + "/{path}";
    public static String GET_ULASAN_BY_ID = Constant.BASE_URL + "/ulasan/{id}";

    //    Post Ulasan
    @Step("Add ulasan with valid/invalid json")
    public void postUlasan(File json, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add ulasan with valid/invalid json and without ID")
    public void postUlasan(File json) {
        SerenityRest.given()
                .pathParam("id", "")
                .contentType(ContentType.JSON)
                .body(json);
    }

    //    Get All Data Ulasan
    @Step("Get all data ulasan with valid/invalid url")
    public void getAllDataUlasan(String path){
        SerenityRest.given()
                .pathParam("path", path);
    }

    //    Get Single Data Ulasan
    @Step("Get single data ulasan with valid/unregister id")
    public void getSingleDataUlasan(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single data ulasan with special char as id")
    public void getSingleDataUlasan(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
}
