package starter.GuruMu.StepDef.Student;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.StudentAPI;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class PostStudentStepDef {
    @Steps
    StudentAPI studentAPI;

    @Given("Add murid with valid json")
    public void addStudentWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Student/AddStudent.json");
        studentAPI.postStudent(json);
    }

    @When("Post murid request")
    public void postMuridRequest() {
        SerenityRest.when().post(StudentAPI.STUDENT_URL);
    }

    @Given("Add murid with invalid JSON")
    public void addMuridWithInvalidJSON() {
        File json = new File(Constant.JSON_REQUEST + "/Student/AddInvalidStudent.json");
        studentAPI.postStudent(json);
    }
}
