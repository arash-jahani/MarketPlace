package ir.arashjahani.marketplace.data.network;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.MutableLiveData;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created By ArashJahani on 05
 */

@Singleton
public class RestApiManager implements RestApiHelper {

    MutableLiveData<List<CategoryItem>> mCategoryMutableLiveData =new MutableLiveData<>();
    MutableLiveData<List<ProductItem>> mProductMutableLiveData=new MutableLiveData<>();


    MarketPlaceApiService marketPlaceApiService;

    @Inject
    RestApiManager(MarketPlaceApiService marketPlaceApiService) {
        this.marketPlaceApiService = marketPlaceApiService;
    }

    @Override
    public MutableLiveData<List<CategoryItem>> getCategoryList() {

        marketPlaceApiService.getCategoryList().enqueue(new Callback<WrapperResponse<List<CategoryItem>>>() {
            @Override
            public void onResponse(Call<WrapperResponse<List<CategoryItem>>> call, Response<WrapperResponse<List<CategoryItem>>> response) {

                WrapperResponse<List<CategoryItem>> wrapperResponse=response.body();
                if(wrapperResponse!=null && wrapperResponse.getData()!=null){
                    mCategoryMutableLiveData.setValue(wrapperResponse.getData());

                }


            }

            @Override
            public void onFailure(Call<WrapperResponse<List<CategoryItem>>> call, Throwable t) {

            }
        });

        return mCategoryMutableLiveData;
    }

    @Override
    public MutableLiveData<List<ProductItem>> getProductList(Integer categoryId) {
        marketPlaceApiService.getProductList(categoryId).enqueue(new Callback<WrapperResponse<List<ProductItem>>>() {
            @Override
            public void onResponse(Call<WrapperResponse<List<ProductItem>>> call, Response<WrapperResponse<List<ProductItem>>> response) {

                WrapperResponse<List<ProductItem>> wrapperResponse=response.body();
                if(wrapperResponse!=null && wrapperResponse.getData()!=null){
                    mProductMutableLiveData.setValue(wrapperResponse.getData());

                }


            }

            @Override
            public void onFailure(Call<WrapperResponse<List<ProductItem>>> call, Throwable t) {

            }
        });

        return mProductMutableLiveData;
    }
}
