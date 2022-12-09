package usecases.userinputboundary;

// Application business rules

/**
 * The register input boundary is used to check the correct format of age, phone number and password when user register.
 */
public class RegisterInputBoundary {
    private int age = -2; //Default setting that age is not an integer
    private String phoneNumber = "0"; //Default setting that phoneNumber is not an integer
    private String password = "1"; //Default setting that the password is too short
    public int getAge(String age) {
        try {
            Double.parseDouble(age);
            this.age = Integer.parseInt(age);
        } catch(Exception ignored){}
        return this.age;
    }

    public String getPhoneNumber(String phoneNumber) {
        try {
            Double.parseDouble(phoneNumber);
            this.phoneNumber = phoneNumber;
            int size = phoneNumber.length();
            if(!(size==10)){
                this.phoneNumber = "-1"; //Not a valid length for phone number;
            }
        } catch(Exception ignored){}
        return this.phoneNumber;
    }

    public String getPassword(String password) {
        try {
            int size = password.length();
            if (size >= 6) { // password is valid length
                this.password = password;
            }
        } catch(Exception ignored){}
        return this.password;
    }
}
