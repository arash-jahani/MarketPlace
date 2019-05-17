package ir.arashjahani.marketplace.data;

import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Maybe;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;

/**
 * Created By ArashJahani on 05
 */
 interface DataRepositoryHelper {

    Maybe<WrapperResponse<List<CategoryItem>>> loadCategoryList();

    Maybe<WrapperResponse<List<ProductItem>>>  loadProductList(@NonNull Integer categoryId);

    void loadUserOrderList();

}
