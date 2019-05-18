package ir.arashjahani.marketplace.viewmodel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ir.arashjahani.marketplace.data.DataRepositoryHelper;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;

/**
 * Created By ArashJahani on 05
 */
public class ProductListViewModel extends ViewModel {

    DataRepositoryHelper dataRepositoryHelper;

    @Inject
    ProductListViewModel(@NonNull DataRepositoryHelper dataRepository) {
        dataRepositoryHelper =dataRepository;
    }

    public MutableLiveData<List<ProductItem>> getProductList(Integer categoryId) {
        return dataRepositoryHelper.loadProductList(categoryId);
    }
}
