package starter.GuruMu.Utils;

public class Payload {

    public String bodyRequestRegister(String nama, String email, String password) {
        String jsonString;
        jsonString = "{";
        jsonString += "\"nama\": \"" + nama + "\",";
        jsonString += "\"email\": \"" + email + "\",";
        jsonString += "\"password\": \"" + password + "\"";
        jsonString += "}";

        return jsonString;
    }

    public String bodyRequestLogin(String email, String password) {
        String jsonString;
        jsonString = "{";
        jsonString += "\"email\": \"" + email + "\",";
        jsonString += "\"password\": \"" + password + "\"";
        jsonString += "}";

        return jsonString;
    }
}
