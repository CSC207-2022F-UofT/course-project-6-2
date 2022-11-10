package users;

import java.util.ArrayList;

public class Seller extends User {

    private String storeName;
    public ArrayList<String> orderInProgress;
    public ArrayList<String> orderCompleted;

    /**
     * Construct an instance of the entity Seller.
     * @param accountName The account name of the seller.
     * @param phoneNumber The phone number of the seller.
     * @param passWord The password of the seller.
     * @param address The address of the seller.
     * @param storeName The store name.
     * @param orderInProgress The list of order numbers that are in progress.
     * @param orderCompleted The list of order numbers that are already completed.
     */
    public Seller(String accountName, String phoneNumber, String passWord, String address, String storeName, ArrayList<String> orderInProgress, ArrayList<String> orderCompleted) {
        super(accountName, phoneNumber, passWord, address);
        this.storeName = storeName;
        this.orderInProgress = orderInProgress;
        this.orderCompleted = orderCompleted;
    }

    /**
     * The setter methods of the new instance values.
     */

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setOrderInProgress(ArrayList<String> orderInProgress) {
        this.orderInProgress = orderInProgress;
    }

    public void setOrderCompleted(ArrayList<String> orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    /**
     * The getter methods for the new instance values.
     */
    public String getStoreName(){
        return this.storeName;
    }

    public ArrayList<String> getOrderInProgress() {
        return this.orderInProgress;
    }

    public ArrayList<String> getOrderCompleted() {
        return this.orderCompleted;
    }

}
