package ir.arashjahani.marketplace.ui.main.category;

import android.view.View;

import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;

/**
 * Created By ArashJahani on 05
 */
public interface CategoryItemCallback {
      void onCategoryItemClick(View view, CategoryItem categoryItem);

}
