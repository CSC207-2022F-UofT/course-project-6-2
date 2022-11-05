package users;

public abstract class User {
    private String accountName;
    private String phoneNumber;
    private String passWord;
    private String address;

    public User(String accountName, String phoneNumber, String passWord, String address) {
        this.accountName = accountName;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
