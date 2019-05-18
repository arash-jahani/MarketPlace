package ir.arashjahani.marketplace.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import ir.arashjahani.marketplace.MarketPlaceApplication;
import ir.arashjahani.marketplace.data.DataRepository;
import ir.arashjahani.marketplace.di.ApplicationContext;
import ir.arashjahani.marketplace.di.module.ActivityBuilderModule;
import ir.arashjahani.marketplace.di.module.ApplicationModule;

/**
 * Created By ArashJahani on 05
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        ActivityBuilderModule.class
})
public interface ApplicationComponent {


    void inject(MarketPlaceApplication application);

    @ApplicationContext
    Context context();

    Application application();

    DataRepository getDataRepository();

}
