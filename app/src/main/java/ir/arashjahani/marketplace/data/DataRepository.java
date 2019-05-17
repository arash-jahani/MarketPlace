package ir.arashjahani.marketplace.data;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Maybe;
import ir.arashjahani.marketplace.data.network.RestApiManager;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;

/**
 * Created By ArashJahani on 05
 */
public class DataRepository implements DataRepositoryHelper {

    private Context context;
    private RestApiManager restApiManager;

    @Inject
    public DataRepository( Context context, RestApiManager restApiManager) {
        this.context = context;
        this.restApiManager = restApiManager;
    }


    @Override
    public Maybe<WrapperResponse<List<CategoryItem>>> loadCategoryList() {
        return restApiManager.getCategoryList();
    }

    @Override
    public Maybe<WrapperResponse<List<ProductItem>>> loadProductList(@NonNull Integer categoryId) {
        return restApiManager.getProductList(categoryId);
    }

    @Override
    public void loadUserOrderList() {

    }
}
