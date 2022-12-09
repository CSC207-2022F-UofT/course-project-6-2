package usecases.customerusecases;

import entities.users.Seller;
import usecases.databaseusecases.UserRuntimeDataBase;

import java.util.HashMap;
import java.util.Map;

/**
 * The search for seller use case is used when the customer search for the seller in the customer service.
 */
public class SearchForSeller {
    static String phoneNumber;
    public static boolean sellerExists(String storeName) {
        // value whose key is to be searched
        HashMap<String, Seller> allSellers = UserRuntimeDataBase.getSellers();
        HashMap<String, String> searchField2 = new HashMap<>();

        // iterate each entry of hashmap
        for (Map.Entry<String, Seller> entry : allSellers.entrySet()) {
            searchField2.put(entry.getValue().getStoreName(), entry.getKey());
        }
        phoneNumber = searchField2.get(storeName);
        return searchField2.containsKey(storeName);
    }
    public static String getPhoneNumber(){
        return phoneNumber;
    }
}
