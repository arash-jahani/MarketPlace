package ir.arashjahani.marketplace.ui.main.product;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.arashjahani.marketplace.R;
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.di.Injectable;
import ir.arashjahani.marketplace.viewmodel.ProductListViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment implements Injectable, ProductItemCallback {

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @BindView(R.id.rv_product)
    RecyclerView mRvProduct;

    private ProductListViewModel mProductListViewModel;
    private ProductListAdapter mProductListAdapter;


    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(mRvProduct.getContext());
        mRvProduct.setLayoutManager(gridLayoutManager);

        mProductListAdapter = new ProductListAdapter(this);


        mRvProduct.setAdapter(mProductListAdapter);


        mProductListViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ProductListViewModel.class);

        mProductListViewModel.getProductList(1)
                .observe(this, productItems -> {
                    mProductListAdapter.setData(productItems);
                    mProductListAdapter.notifyDataSetChanged();
                });
    }

    @Override
    public void onBuyProductClick(ProductItem productItem) {

    }
}