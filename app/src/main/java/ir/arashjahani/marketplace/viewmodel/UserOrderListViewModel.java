package ir.arashjahani.marketplace.viewmodel;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created By ArashJahani on 05/19
 */
public class UserOrderListViewModel extends ViewModel {


    @Inject
    public UserOrderListViewModel() {
    }


    MutableLiveData<String> getOrderState(){

        Observable<String> observable = Observable.just("آماده سازی", "ارسال شده", "تحویل موفق");
        observable
                .flatMap()
                .flatMap()
                .subscribe()

    }

}
