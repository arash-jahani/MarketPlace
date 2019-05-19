package ir.arashjahani.marketplace.ui.main.order;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.arashjahani.marketplace.R;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.di.Injectable;
import ir.arashjahani.marketplace.ui.main.product.ProductItemCallback;
import ir.arashjahani.marketplace.ui.main.product.ProductListAdapter;
import ir.arashjahani.marketplace.utils.PriceUtils;
import ir.arashjahani.marketplace.viewmodel.ProductListViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;


public class UserOrderListFragment extends Fragment implements Injectable {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.img_product_icon)
    public ImageView imgProductIcon;
    @BindView(R.id.lbl_product_title)
    public TextView lblProductTitle;
    @BindView(R.id.lbl_product_price)
    public TextView lblProductPrice;
    @BindView(R.id.lbl_product_discount_price)
    public TextView lblProductDiscountPrice;

    ProductItem productItem;

    public UserOrderListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        productItem=(ProductItem) getArguments().getSerializable("productItem");


        lblProductTitle.setText(productItem.getTitle());
        lblProductPrice.setText(PriceUtils.format(productItem.getPrice()));
        lblProductDiscountPrice.setText(PriceUtils.calcDiscount(productItem.getPrice(),productItem.getDiscount()));


        Glide.with(this)
                .load(productItem.getIcon())
                .into(imgProductIcon);
    }

}