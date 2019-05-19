package ir.arashjahani.marketplace.di.module;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import ir.arashjahani.marketplace.di.ViewModelKey;
import ir.arashjahani.marketplace.viewmodel.CategoryListViewModel;
import ir.arashjahani.marketplace.viewmodel.ProductListViewModel;
import ir.arashjahani.marketplace.viewmodel.ProjectViewModelFactory;
import ir.arashjahani.marketplace.viewmodel.UserLocationViewModel;
import ir.arashjahani.marketplace.viewmodel.UserOrderListViewModel;

/**
 * Created By ArashJahani on 05
 */

@Module
public abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(CategoryListViewModel.class)
    abstract ViewModel bindCategoryListViewModel(CategoryListViewModel categoryListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel.class)
    abstract ViewModel bindProductListViewModel(ProductListViewModel productListViewModel);


    @Binds
    @IntoMap
    @ViewModelKey(UserLocationViewModel.class)
    abstract ViewModel bindUserLocationViewModel(UserLocationViewModel userLocationViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(UserOrderListViewModel.class)
    abstract ViewModel bindUserOrderListViewModel(UserOrderListViewModel userOrderListViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ProjectViewModelFactory projectViewModelFactory);
}
