package users;

public abstract class User {
    private String accountName;
    private String phoneNumber;
    private String passWord;
    private String address;

    /**
     * Construct an instance of the entity User.
     * @param accountName The account name of the user.
     * @param phoneNumber The phone number of the user.
     * @param passWord The password of the user.
     * @param address The address of the user.
     */
    public User(String accountName, String phoneNumber, String passWord, String address) {
        this.accountName = accountName;
        this.phoneNumber = phoneNumber;
        this.passWord = passWord;
        this.address = address;
    }

    /**
     * The Setter methods of the instance values.
     */
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

    /**
     * The getter methods of the instance values.
     */
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
