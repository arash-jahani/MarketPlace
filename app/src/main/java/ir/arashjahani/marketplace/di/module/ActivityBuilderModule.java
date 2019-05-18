package ir.arashjahani.marketplace.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import ir.arashjahani.marketplace.ui.main.MainActivity;

/**
 * Created By ArashJahani on 05
 */
@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity contributeMainActivity();

}
