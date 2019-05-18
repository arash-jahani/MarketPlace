package ir.arashjahani.marketplace.data;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import ir.arashjahani.marketplace.data.network.RestApiHelper;
import ir.arashjahani.marketplace.data.network.RestApiManager;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;

/**
 * Created By ArashJahani on 05
 */
@Singleton
public class DataRepository implements DataRepositoryHelper {

    private RestApiHelper restApiHelper;

    @Inject
    DataRepository(RestApiHelper restApiHelper) {
        this.restApiHelper = restApiHelper;
    }


    @Override
    public MutableLiveData<List<CategoryItem>> loadCategoryList() {
        return restApiHelper.getCategoryList();
    }

    @Override
    public MutableLiveData<List<ProductItem>> loadProductList(@NonNull Integer categoryId) {
        return restApiHelper.getProductList(categoryId);
    }

    @Override
    public void loadUserOrderList() {

    }
}
