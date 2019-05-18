package ir.arashjahani.marketplace.data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Maybe;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;

/**
 * Created By ArashJahani on 05
 */
public interface DataRepositoryHelper {

    MutableLiveData<List<CategoryItem>> loadCategoryList();

    MutableLiveData<List<ProductItem>>  loadProductList(@NonNull Integer categoryId);

    void loadUserOrderList();

}
