package ir.arashjahani.marketplace.viewmodel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ir.arashjahani.marketplace.data.DataRepository;
import ir.arashjahani.marketplace.data.DataRepositoryHelper;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;

/**
 * Created By ArashJahani on 05
 */
public class CategoryListViewModel extends ViewModel {

    MutableLiveData<List<CategoryItem>> categoriesLiveData;

    @Inject
    CategoryListViewModel(@NonNull DataRepositoryHelper dataRepository) {
        categoriesLiveData=dataRepository.loadCategoryList();
    }

    public MutableLiveData<List<CategoryItem>> getCategories() {
        return categoriesLiveData;
    }
}
