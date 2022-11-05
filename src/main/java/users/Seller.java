package users;

public class Seller extends User {

    private String storeName;

    public Seller(String accountName, String phoneNumber, String passWord, String address, String storeName) {
        super(accountName, phoneNumber, passWord, address);
        this.storeName = storeName;
    }
}
