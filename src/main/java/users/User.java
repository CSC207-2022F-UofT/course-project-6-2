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

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAddress() {
        return address;
    }

    public String getPassWord() {
        return passWord;
    }
}
