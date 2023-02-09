package starter.GuruMu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GuruMu.Utils.Constant;

import java.io.File;
import java.util.Map;

public class StudentAPI {
    public static String STUDENT_URL = Constant.BASE_URL + "/siswa";

    @Step("add student with valid/invalid json")
    public void postStudent(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Update murid with valid/invalid token and valid/invalid form-data")
    public void putStudent(String token, Map<String, String> formData) {
        SerenityRest.given()
                .header("Authorization", "Bearer" + token)
                .contentType(ContentType.TEXT)
                .formParams(formData);
    }

    @Step("Update murid without valid/invalid token and valid/invalid form-data")
    public void putStudent(Map<String, String> formData) {
        SerenityRest.given()
                .contentType(ContentType.TEXT)
                .formParams(formData);
    }

    @Step("Update murid with valid/invalid token and without valid/invalid form-data")
    public void putStudent(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer" + token);
    }

    @Step("Update murid with without valid/invalid token and without valid/invalid form-data")
    public void putStudent() {
        SerenityRest.given();
    }

    @Step("Get data murid with token")
    public void getStudent(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer" + token);
    }

    @Step("Get data murid without token")
    public void getStudent() {
        SerenityRest.given();
    }

    @Step("Delete data murid with token")
    public void deleteStudent(String token) {
        SerenityRest.given()
                .header("Authorization", "Bearer" + token);
    }

    @Step("Delete data murid without token")
    public void deleteStudent() {
        SerenityRest.given();
    }
}
