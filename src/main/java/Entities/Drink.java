package Entities;

import UseCases.UserUseCases.UserRuntimeDataBase;

import java.util.Date;

// Entities Layer

public class Drink {
    private String name;
    private float price;
    private String description;
    private String ingredient;
    private int volume;
    private Date productionData;
    private Date expirationDate;
    private float discount;
    private String storeName;

    /**
     * Construct an instance of the entity drink.
     *
     * @param name           The name of the drink.
     * @param price          The price of the drink.
     * @param description    The brief description of the drink.
     * @param ingredient     The ingredient of the drink.
     * @param volume         The volume in ml of the drink.
     * @param productionData The date of production of the drink.
     * @param expirationDate The date of expiration of the drink.
     * @param discount       The amount of discount of this drink right now.
     */
    public Drink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.ingredient = ingredient;
        this.volume = volume;
        this.productionData = productionData;
        this.expirationDate = expirationDate;
        this.discount = discount;
        this.storeName = UserRuntimeDataBase.getCurrentSeller().getStoreName();
    }

    /**
     * The setter methods of the instance values.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setProductionData(Date productionData) {
        this.productionData = productionData;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * The getter methods of the instance values.
     */
    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIngredient() {
        return this.ingredient;
    }

    public int getVolume() {
        return this.volume;
    }

    public Date getProductionData() {
        return this.productionData;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public float getDiscount() {
        return this.discount;
    }

    public String getStoreName() {
        return this.storeName;
    }
}
