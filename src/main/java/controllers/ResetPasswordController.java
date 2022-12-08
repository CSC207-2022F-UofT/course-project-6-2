package controllers;

import presentor.ResponsePresenter;
import usecases.userresponsemodel.UserResponseModel;
import usecases.loginregisterusecases.ResetUserPassword;
import usecases.userinputboundary.RegisterInputBoundary;

public class ResetPasswordController {
    private final String phoneNumber;
    private final String newPassword;
    private final String confirmNewPassword;

    /**
     * Construct an instance of ResetPasswordController.
     * @param phoneNumber The phone number entered by the user
     * @param newPassword The password entered by the user
     * @param confirmNewPassword The confirmation password entered by the user
     **/

    public ResetPasswordController(String phoneNumber, String newPassword, String confirmNewPassword) {
        this.phoneNumber = phoneNumber;
        this.newPassword = new RegisterInputBoundary().getPassword(newPassword);
        this.confirmNewPassword = confirmNewPassword;
    }

    public boolean resetPassword(){
        boolean resultResult = ResetUserPassword.resetPassword(phoneNumber, newPassword, confirmNewPassword);
        new ResponsePresenter(UserResponseModel.resetResponse(resultResult)).messagePresenter();
        return resultResult;
    }
}
