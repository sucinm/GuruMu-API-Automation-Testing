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
    public static String GET_ALL_SESI = Constant.BASE_URL + "/sesiku";
    public static String GET_ALL_SESI_PATH = Constant.BASE_URL + "/{path}";
    public static String GET_SESI_VALID = Constant.BASE_URL + "/sesiku?role=guru&status=selesai";
    public static String GET_SESI_SISWA = Constant.BASE_URL + "/sesiku?role=siswa&status=selesai";
    public static String GET_SESI_WITHOUT_PARAM = Constant.BASE_URL + "/sesiku";
    public static String GET_SESI_INVALID_PARAM = Constant.BASE_URL + "/sesiku?role=a&status=iniapa";
    public static String GET_SISWA_EXTRA = Constant.BASE_URL + "/sesiku?role=siswa&status=ongoing&reservasi_id=37";
    public static String GET_SISWA_TYPE = Constant.BASE_URL + "/sesiku?role=siswa&status=%$";
    public static String GET_SISWA_MISSING = Constant.BASE_URL + "/sesiku?role=siswa";
    public static String GET_SISWA_BLANK = Constant.BASE_URL + "/sesiku?role=siswa&status=";

    //    Post Jadwal Guru
    @Step("Add jadwal guru with valid json & token")
    public void postPostJadwalGuru(File json, String token)
    {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(json);
    }


    //    Get All Data Sesi Guru
    @Step("Get all data sesi guru with valid/invalid url")
    public void getAllDataSesiGuru(String path)
    {
        SerenityRest.given()
                .pathParam("path", path);
    }

    @Step("Get all data sesi guru with valid/invalid url")
    public void getAllDataSesiGuruWithRoleAndStatus(String role, String status)
    {
        SerenityRest.given()
                .queryParam("role", role)
                .queryParam("status", status);
    }

    @Step("Get sesi guru with valid/invalid token")
    public void setGetAllSesiWihoutForm(String token){
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.TEXT);
    }
}
