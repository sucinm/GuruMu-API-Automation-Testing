package starter.GuruMu.StepDef.Student;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.GuruMu.StudentAPI;
import starter.GuruMu.Utils.Authorization;

import java.util.HashMap;
import java.util.Map;

public class PutStudentStepDef {
    @Steps
    StudentAPI studentAPI;

    Authorization authorization = new Authorization();

    @Given("Update murid with valid token and valid form-data")
    public void updateStudent(){
        studentAPI.putStudent(authorization.getToken(), getValidFormData());
    }

    private Map<String, String> getValidFormData(){
        Map<String, String> data = new HashMap<String, String>();
        data.put("nama", "Uyuy");
        data.put("email", "uyuyks@gmail.com");
        data.put("alamat", "Jakarta Barat 12");
        data.put("telepon", "0822229999");
        data.put("avatar", "uyuy.png");
        return data;
    }

    private Map<String, String> getInvalidFormData(){
        Map<String, String> data = new HashMap<String, String>();
        data.put("nama", "Uyuy");
        data.put("email", "");
        data.put("alamat", "");
        data.put("telepon", "0822229999");
        data.put("avatar", "uyuy.png");
        return data;
    }

    @When("Put murid request")
    public void putMuridRequest() {
        SerenityRest.when().put(StudentAPI.STUDENT_URL);
    }

    @Given("Update murid with expired token and valid form-data")
    public void updateMuridWithExpiredTokenAndValidFormData() {
        studentAPI.putStudent(Authorization.EXPIRED_TOKEN, getValidFormData());
    }

    @Given("Update murid with expired token and invalid form-data")
    public void updateMuridWithExpiredTokenAndInvalidFormData() {
        studentAPI.putStudent(Authorization.EXPIRED_TOKEN, getInvalidFormData());
    }

    @Given("Update murid without token and valid form-data")
    public void updateMuridWithoutTokenAndValidFormData() {
        studentAPI.putStudent(getValidFormData());
    }

    @Given("Update murid without token and invalid form-data")
    public void updateMuridWithoutTokenAndInvalidFormData() {
        studentAPI.putStudent(getInvalidFormData());
    }

    @Given("Update murid with valid token and without form-data")
    public void updateMuridWithValidTokenAndWithoutFormData() {
        studentAPI.putStudent(authorization.getToken());
    }

    @Given("Update murid with expired token and without form-data")
    public void updateMuridWithExpiredTokenAndWithoutFormData() {
        studentAPI.putStudent(Authorization.EXPIRED_TOKEN);
    }

    @Given("Update murid without token and without form-data")
    public void updateMuridWithoutTokenAndWithoutFormData() {
        studentAPI.putStudent();
    }
}
