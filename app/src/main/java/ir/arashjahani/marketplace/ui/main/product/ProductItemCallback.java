package ir.arashjahani.marketplace.ui.main.product;

import android.view.View;

import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;

/**
 * Created By ArashJahani on 05
 */
public interface ProductItemCallback {

      void onBuyProductClick(View view, ProductItem productItem);

}
