package controllers;

// Interface adapters

import presentor.ResponsePresenter;
import usecases.userresponsemodel.UserResponseModel;
import usecases.databaseusecases.UserRuntimeDataBase;
import usecases.loginregisterusecases.LoginUser;

public class LoginController {
    private final String phoneNumber;
    private final String password;

    /**
     * Construct an instance of LoginController.
     * @param phoneNumber The phone number entered by the user
     * @param password The password entered by the user
     **/
    public LoginController(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String loginUser() {
        String loginResult = LoginUser.login(phoneNumber, password);
        new ResponsePresenter(UserResponseModel.loginResponse(loginResult)).messagePresenter();

        if (loginResult.equals("Seller")) {
            UserRuntimeDataBase.constructCurrentSeller(phoneNumber);
        } else if (loginResult.equals("Customer")) {
            UserRuntimeDataBase.constructCurrentCustomer(phoneNumber);
        }
        return loginResult;
    }
}
