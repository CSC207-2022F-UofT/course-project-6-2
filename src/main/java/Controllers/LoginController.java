package Controllers;

public class LoginController {
    final String phoneNum;
    public LoginController(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
}
