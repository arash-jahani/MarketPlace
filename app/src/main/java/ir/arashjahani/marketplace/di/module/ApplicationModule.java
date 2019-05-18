package ir.arashjahani.marketplace.di.module;

import android.app.Application;
import android.content.Context;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.arashjahani.marketplace.data.DataRepository;
import ir.arashjahani.marketplace.data.DataRepositoryHelper;
import ir.arashjahani.marketplace.data.network.FakeInterceptor;
import ir.arashjahani.marketplace.data.network.MarketPlaceApiService;
import ir.arashjahani.marketplace.data.network.RestApiHelper;
import ir.arashjahani.marketplace.data.network.RestApiManager;
import ir.arashjahani.marketplace.data.utils.Constants;
import ir.arashjahani.marketplace.di.ApplicationContext;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By ArashJahani on 05
 */

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataRepositoryHelper provideDataRepository(DataRepository mDataRepository) {
        return mDataRepository;
    }

    @Provides
    @Singleton
    RestApiHelper provideRestApiHelper(RestApiManager restApiManager) {
        return restApiManager;
    }


    //return client
    @Provides
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        return new OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(new FakeInterceptor(mApplication)).build();

    }

    //return retrofit instance
    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    //return apiService instance
    @Provides
    public MarketPlaceApiService provideApiService() {
        return provideRetrofit(Constants.MOCK_URL, provideClient()).create(MarketPlaceApiService.class);
    }



}
