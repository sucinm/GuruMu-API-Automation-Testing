package starter.GuruMu;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.GuruMu.Utils.Constant;

import java.io.File;
import java.util.Map;

public class JadwalGuruAPI
{
    public static String POST_JADWAL_GURU = Constant.BASE_URL + "/jadwal";
    public static String GET_ALL_SESI = Constant.BASE_URL + "/{path}";
    public static String GET_SESI = Constant.BASE_URL + "/sesiku";

    //    Post Jadwal Guru
    @Step("Add jadwal guru with valid/invalid json")
    public void setPostJadwalGuru(File json)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //    Get All Data Sesi Guru
    @Step("Get all data sesi guru with valid/invalid url")
    public void getAllDataSesiGuru(String path)
    {
        SerenityRest.given()
                .pathParam("path", path);
    }

    @Step("Get sesi guru with valid/invalid token and valid/invalid form-data")
    public void setGetAllSesi(String token, Map<String,String> formParam){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.TEXT)
                .formParams(formParam);
    }

    @Step("Get sesi guru with valid/invalid token")
    public void setGetAllSesiWihoutForm(String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.TEXT);
    }
}
