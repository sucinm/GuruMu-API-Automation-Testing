package starter.GuruMu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GuruMu.Utils.Constant;

import java.io.File;
import java.util.Map;

public class GuruAPI {
    public static String POST_GURU = Constant.BASE_URL + "/guru";
    public static String PUT_GURU = Constant.BASE_URL + "/guru";
    public static String GET_ALL_GURU = Constant.BASE_URL + "/{path}";
    public static String GET_GURU_BY_ID = Constant.BASE_URL + "/guru/{id}";
    public static String DELETE_GURU = Constant.BASE_URL + "/guru";

    //    Post Guru
    @Step("Add guru with valid/invalid json")
    public void postGuru(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Add guru with string json")
    public void postGuru(String json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //    Put Guru
    @Step("Update guru with valid/invalid token and valid/invalid form-data")
    public void putGuru(String token, Map<String,String> formParam){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.URLENC)
                .formParams(formParam);
    }

    @Step("Update guru without token and valid/invalid form-data")
    public void putGuru(Map<String,String> formParam){
        SerenityRest.given()
                .contentType(ContentType.TEXT)
                .formParams(formParam);
    }

    @Step("Update guru with valid/invalid token and without form-data")
    public void putGuru(String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    @Step("Update guru without token and without form-data")
    public void putGuru(){
        SerenityRest.given();
    }

    //    Get All Data Guru
    @Step("Get all data guru with valid/invalid url")
    public void getAllDataGuru(String path){
        SerenityRest.given()
                .pathParam("path", path);
    }

    //    Get Single Data Guru
    @Step("Get single data guru with valid/unregister id")
    public void getSingleDataGuru(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single data guru with special char as id")
    public void getSingleDataGuru(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    //    Delete Guru
    @Step("Delete guru with valid/expired token")
    public void deleteGuru(String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token);
    }

    @Step("Delete guru without token")
    public void deleteGuru(){
        SerenityRest.given();
    }
}
