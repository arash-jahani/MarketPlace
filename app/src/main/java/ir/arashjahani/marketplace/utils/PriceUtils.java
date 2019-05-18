package ir.arashjahani.marketplace.utils;

import java.text.DecimalFormat;

/**
 * Created By ArashJahani on 05
 */
public class PriceUtils {


    public static String format(Object price){
        DecimalFormat formatter = new DecimalFormat("###,###,###,###");
        return PersianUtils.toFarsi(formatter.format(price));
    }

    public static String calcDiscount(Long price,Integer discount){
        Float newPrice = price-(price*((float)discount /  100));
        return format(newPrice);

    }

}
