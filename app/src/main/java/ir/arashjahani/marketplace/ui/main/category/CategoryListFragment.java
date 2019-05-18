package ir.arashjahani.marketplace.ui.main.category;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.arashjahani.marketplace.R;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;
import ir.arashjahani.marketplace.di.Injectable;
import ir.arashjahani.marketplace.viewmodel.CategoryListViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryListFragment extends Fragment implements Injectable,CategoryItemCallback {

    @Inject
    ViewModelProvider.Factory viewModelFactory;


    @BindView(R.id.rv_category)
    RecyclerView mRvCategory;

    private CategoryListViewModel mCategoryListViewModel;
    private CategoryListAdapter mCategoryListAdapter;


    public CategoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(mRvCategory.getContext());
        mRvCategory.setLayoutManager(gridLayoutManager);

        mCategoryListAdapter = new CategoryListAdapter(this);


        mRvCategory.setAdapter(mCategoryListAdapter);


        mCategoryListViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(CategoryListViewModel.class);

        mCategoryListViewModel.getCategories()
                .observe(this, categoryItems -> {
                    mCategoryListAdapter.setData(categoryItems);
                    mCategoryListAdapter.notifyDataSetChanged();
                });
    }

    @Override
    public void onCategoryItemClick(View view,CategoryItem categoryItem) {

        Bundle bundle = new Bundle();
        bundle.putInt("categoryId", categoryItem.getId());
        Navigation.findNavController(view).navigate(R.id.productListFragment);


    }
}
