package ir.arashjahani.marketplace.data.network;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.data.network.pojo.WrapperResponse;

/**
 * Created By ArashJahani on 05
 */

@Singleton
public class RestApiManager implements RestApiHelper {

    MarketPlaceApiService marketPlaceApiService;

    @Inject
    public RestApiManager(MarketPlaceApiService marketPlaceApiService) {
        this.marketPlaceApiService = marketPlaceApiService;
    }

    @Override
    public Maybe<WrapperResponse<List<CategoryItem>>> getCategoryList() {
        return marketPlaceApiService.getCategoryList();
    }

    @Override
    public Maybe<WrapperResponse<List<ProductItem>>> getProductList(Integer categoryId) {
        return marketPlaceApiService.getProductList(categoryId);
    }
}
