package users;

import java.util.ArrayList;

public class Seller extends User {

    private String storeName;
    public ArrayList<String> orderInProgress;
    public ArrayList<String> orderCompleted;

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
