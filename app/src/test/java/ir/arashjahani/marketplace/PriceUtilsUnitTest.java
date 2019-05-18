package ir.arashjahani.marketplace;

import org.junit.Test;

import ir.arashjahani.marketplace.utils.PriceUtils;

import static org.junit.Assert.assertEquals;

/**
 * Created By ArashJahani on 05
 */
public class PriceUtilsUnitTest {

    @Test
    public void check(){

        assertEquals(PriceUtils.calcDiscount((long) 20000,15),"17,000");

    }

}
