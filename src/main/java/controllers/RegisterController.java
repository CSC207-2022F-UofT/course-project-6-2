package controllers;

// Interface adapters

import presentor.ResponsePresenter;
import usecases.userresponsemodel.UserResponseModel;
import usecases.loginregisterusecases.RegisterUser;
import usecases.userinputboundary.RegisterInputBoundary;

public class RegisterController {
    private final String accountName;
    private final String phoneNumber;
    private final String password;
    private final String confirmPass;
    private final String address;
    private final int age;
    private final String storeName;

    /**
     * Construct an instance of RegisterController.
     * @param phoneNumber The phone number entered by the user
     * @param password The password entered by the user
     * @param confirmPass The confirmation password entered by the user
     * @param address The address entered by the user
     * @param age The age entered by the user or -1
     * @param storeName The store name entered by the user or null
     **/
    public RegisterController(String accountName, String phoneNumber, String password, String confirmPass,
                              String address, String age, String storeName){
        this.accountName = accountName;
        this.phoneNumber = new RegisterInputBoundary().getPhoneNumber(phoneNumber);
        this.password = new RegisterInputBoundary().getPassword(password);
        this.confirmPass = confirmPass;
        this.address = address;
        this.age = new RegisterInputBoundary().getAge(age);
        this.storeName = storeName;
    }

    public String registerUser() {
        String registerResult = RegisterUser.registerUser(accountName, phoneNumber, password,
                confirmPass, address, age, storeName);
        new ResponsePresenter(new UserResponseModel().registerResponse(registerResult)).messagePresenter();
        return registerResult;
    }
}
