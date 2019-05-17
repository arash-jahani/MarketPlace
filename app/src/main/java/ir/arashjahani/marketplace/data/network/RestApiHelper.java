package ir.arashjahani.marketplace.data.network;

import java.util.List;

import io.reactivex.Maybe;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;

/**
 * Created By ArashJahani on 05
 */
interface RestApiHelper {

    Maybe<WrapperResponse<List<CategoryItem>>> getCategoryList();

    Maybe<WrapperResponse<List<ProductItem>>> getProductList(Integer categoryId);

}
