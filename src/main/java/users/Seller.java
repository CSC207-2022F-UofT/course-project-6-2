package users;

import java.util.ArrayList;

public class Seller extends User{
    public String sellerAddress;
    public ArrayList<String> orderInProgress;
    public ArrayList<String> orderCompleted;

    /**
     * Construct an instance of the entity Seller.
     * @param name The store name of the seller.
     * @param password The password of the seller store.
     * @param phoneNumber The phone number of the store.
     * @param sellerAddress The address of the seller store.
     * @param orderInProgress The list of orders that are still in progress.
     * @param orderCompleted The list of orders that are already completed.
     */
    public Seller(String name, String password, int phoneNumber, String sellerAddress, ArrayList<String> orderInProgress, ArrayList<String> orderCompleted){
        super(name, password, phoneNumber);
        this.sellerAddress = sellerAddress;
        this.orderInProgress = orderInProgress;
        this.orderCompleted = orderCompleted;
    }

    /**
     * The setter methods of the new instance values.
     */
    public void setSellerAddress(String sellerAddress) {
        this.sellerAddress = sellerAddress;
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
    public String getSellerAddress(){
        return this.sellerAddress;
    }

    public ArrayList<String> getOrderInProgress() {
        return this.orderInProgress;
    }

    public ArrayList<String> getOrderCompleted() {
        return this.orderCompleted;
    }
}
