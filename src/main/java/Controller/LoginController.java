package Controller;

public class LoginController {
    final String phoneNumber;

    public LoginController(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
