package ir.arashjahani.marketplace.data.network;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;

/**
 * Created By ArashJahani on 05
 */
public interface RestApiHelper {

    MutableLiveData<List<CategoryItem>> getCategoryList();

    MutableLiveData<List<ProductItem>> getProductList(Integer categoryId);

}
