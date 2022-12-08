package controllers;

// Interface adapters

import presentor.ResponsePresenter;
import usecases.sellerusecases.SellerModifyDrink;
import usecases.userinputboundary.DrinkInputBoundary;
import usecases.userresponsemodel.UserResponseModel;

import java.util.Date;

public class AddModifyDrinkController {
    private final String name;
    private final Float price;
    private final String description;
    private final String ingredient;
    private final Integer volume;
    private final Date productionDate;
    private final Date expirationDate;
    private final Float discount;

    /**
     * Construct an instance of AddModifyDrinkController
     * @param name The name of the drink entered by the user
     * @param price The price of the drink entered by the user
     * @param description The description of the drink entered by the user
     * @param ingredient The ingredients of the drink entered by the user
     * @param volume The volume of the drink entered by the user
     * @param productionDate The production date of the drink entered by the user
     * @param expirationDate The expiration date of the drink entered by the user
     * @param discount The discount of the drink entered by the user
     */

    public AddModifyDrinkController(String name, String price, String description, String ingredient,
                                    String volume, String productionDate, String expirationDate, String discount) {
        this.name = name;
        this.price = new DrinkInputBoundary().getPrice(price);
        this.description = description;
        this.ingredient = ingredient;
        this.volume = new DrinkInputBoundary().getVolume(volume);
        this.productionDate = new DrinkInputBoundary().getDate(productionDate);
        this.expirationDate = new DrinkInputBoundary().getDate(expirationDate);
        this.discount = new DrinkInputBoundary().getDiscount(discount);
    }

    public String addDrink() {
        SellerModifyDrink sellerModifyDrink = new SellerModifyDrink();
        String addDrinkResult = sellerModifyDrink.addDrink(name, price, description, ingredient, volume,
                productionDate, expirationDate, discount);
        new ResponsePresenter(new UserResponseModel().addModifyDrinkResponse(addDrinkResult)).messagePresenter();
        return addDrinkResult;
    }

    public String modifyDrink() {
        SellerModifyDrink sellerModifyDrink = new SellerModifyDrink();
        String modifyDrinkResult = sellerModifyDrink.modifyDrink(name, price, description, ingredient, volume,
                productionDate, expirationDate, discount);
        new ResponsePresenter(new UserResponseModel().addModifyDrinkResponse(modifyDrinkResult)).messagePresenter();
        return modifyDrinkResult;
    }
}
