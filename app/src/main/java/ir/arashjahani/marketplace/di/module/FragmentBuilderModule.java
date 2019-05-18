package ir.arashjahani.marketplace.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.arashjahani.marketplace.ui.main.category.CategoryListFragment;
import ir.arashjahani.marketplace.ui.main.product.ProductListFragment;

/**
 * Created By ArashJahani on 05
 */
@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract CategoryListFragment contributeCategoryListFragment();

    @ContributesAndroidInjector
    abstract ProductListFragment contributeProductListFragment();

}
