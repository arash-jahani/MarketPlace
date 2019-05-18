package ir.arashjahani.marketplace.ui.main.category;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.arashjahani.marketplace.R;
import ir.arashjahani.marketplace.data.network.pojo.CategoryItem;

/**
 * Created By ArashJahani on 06
 */

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {

    private List<CategoryItem> categoryItems = new ArrayList<>();
    private CategoryItemCallback categoryItemCallback;

    public CategoryListAdapter(CategoryItemCallback categoryItemCallback) {
        this.categoryItemCallback = categoryItemCallback;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_layout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        CategoryItem categoryItem = categoryItems.get(position);

        holder.lblCategoryTitle.setText(categoryItem.getTitle());

        Glide.with(holder.imgCategoryIcon.getContext())
                .load(categoryItem.getIcon())
                .into(holder.imgCategoryIcon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryItemCallback.onCategoryItemClick(view,categoryItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public void setData(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
        notifyDataSetChanged();
    }

    public void clearAdapter() {
        categoryItems.clear();
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class
     */
    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_category_icon)
        public ImageView imgCategoryIcon;
        @BindView(R.id.lbl_category_title)
        public TextView lblCategoryTitle;

        public View itemView;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.itemView = itemView;
        }
    }

}
