package ir.arashjahani.marketplace.data.network;

import java.util.List;

import io.reactivex.Maybe;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created By ArashJahani on 05
 */
public interface MarketPlaceApiService {

    @GET("products/categories")
    Call<WrapperResponse<List<CategoryItem>>> getCategoryList();

     @GET("products/{categoryId}")
    Call<WrapperResponse<List<ProductItem>>> getProductList(@Path("categoryId") Integer categoryId);


}
