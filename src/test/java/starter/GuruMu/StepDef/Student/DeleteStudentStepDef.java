package starter.GuruMu.StepDef.Student;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.StudentAPI;
import starter.GuruMu.Utils.Authorization;

public class DeleteStudentStepDef {
    @Steps
    StudentAPI studentAPI;
    Authorization authorization = new Authorization();

    @Given("Delete single data murid with valid token")
    public void deleteStudent() {
        studentAPI.deleteStudent(authorization.getToken());
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
