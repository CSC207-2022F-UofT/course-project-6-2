package drink;

import java.util.Date;

public class Drink {
    private String name;
    private float price;
    private String description;
    private String ingredient;
    private int volume;
    private Date productionData;
    private Date expirationDate;
    private float discount;

    public Drink(String name, float price, String description, String ingredient, int volume, Date productionData, Date expirationDate, float discount) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.ingredient = ingredient;
        this.volume = volume;
        this.productionData = productionData;
        this.expirationDate = expirationDate;
        this.discount = discount;
    }
}
