package ir.arashjahani.marketplace;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import ir.arashjahani.marketplace.di.AppInjector;
import ir.arashjahani.marketplace.di.component.ApplicationComponent;
import ir.arashjahani.marketplace.di.component.DaggerApplicationComponent;
import ir.arashjahani.marketplace.di.module.ApplicationModule;

/**
 * Created By ArashJahani on 05
 */
public class MarketPlaceApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        AppInjector.init(this);


    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
