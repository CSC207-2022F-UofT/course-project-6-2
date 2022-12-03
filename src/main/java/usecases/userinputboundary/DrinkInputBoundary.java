package usecases.userinputboundary;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DrinkInputBoundary {
    private Float price = -1.0f;
    private Integer volume = -1;
    private Date date = null;
    private Float discount = -1.0f;

    public Float getPrice(String priceText) {
        try {
            Float.parseFloat(priceText);
            this.price = Float.valueOf(priceText);
        } catch(Exception ignored){}
        return price;
    }
    public Integer getVolume(String volumeText){
        try {
            Integer.parseInt(volumeText);
            this.volume = Integer.valueOf(volumeText);
        } catch(Exception ignored){}
        return volume;
    }

    public Date getDate(String dateText){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = format.parse(dateText);
        } catch(Exception ignored){}
        return date;
    }

    public Float getDiscount(String discountText){
        try {
            Float.parseFloat(discountText);
            this.discount = Float.valueOf(discountText);
        } catch(Exception ignored){}
        return discount;
    }
}
