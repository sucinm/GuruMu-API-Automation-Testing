package starter.GuruMu.StepDef.Student;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.StudentAPI;
import starter.GuruMu.Utils.Authorization;
import starter.GuruMu.Utils.Constant;

import java.io.File;

public class GetStudentStepDef {
    @Steps
    StudentAPI studentAPI;
    Authorization authorization = new Authorization();

    @Given("Get data murid with token")
    public void getDataMurid() {
        studentAPI.getStudent(authorization.getToken());
    }

    @When("Get murid request")
    public void getMuridRequest() {
        SerenityRest.when().get(StudentAPI.STUDENT_URL);
    }

    @And("Validate json schema data murid")
    public void validateJsonSchemaDataMurid() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/Student/ResponseGetStudent.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get data murid without token")
    public void getDataMuridWithoutToken() {
        studentAPI.getStudent();
    }

    @Given("Get data murid with expired token")
    public void getDataMuridWithExpiredToken() {
        studentAPI.getStudent(Authorization.EXPIRED_TOKEN);
    }
}
