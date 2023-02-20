package starter.GuruMu.StepDef.Student;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.StudentAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;
import starter.GuruMu.Utils.Payload;

public class DeleteStudentStepDef {
    @Steps
    StudentAPI studentAPI;
    Authorization authorization = new Authorization();

    @Given("Delete single data murid with valid token")
    public void deleteStudent() {
        Payload payload = new Payload();
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(payload.bodyRequestRegister("delete murid", "deletemurid@gmail.com", "deletemurid"))
                .post(StudentAPI.STUDENT_URL);
        String json = payload.bodyRequestLogin("deletemurid@gmail.com", "deletemurid");
        studentAPI.deleteStudent(authorization.getTokenByCustom(json));
    }

    @When("Delete murid request")
    public void deleteMuridRequest() {
        SerenityRest.when().delete(StudentAPI.STUDENT_URL);
    }

    @Given("Delete single data murid with expired token")
    public void deleteSingleDataMuridWithExpiredToken() {
        studentAPI.deleteStudent(Authorization.EXPIRED_TOKEN);
    }

    @Given("Delete single data murid without token")
    public void deleteSingleDataMuridWithoutToken() {
        studentAPI.deleteStudent();
    }
}
