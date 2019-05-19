package ir.arashjahani.marketplace.ui.main.product;

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
import ir.arashjahani.marketplace.data.network.pojo.ProductItem;
import ir.arashjahani.marketplace.utils.PriceUtils;

/**
 * Created By ArashJahani on 06
 */

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {

    private List<ProductItem> productItems = new ArrayList<>();
    private ProductItemCallback productItemCallback;

    public ProductListAdapter(ProductItemCallback productItemCallback) {
        this.productItemCallback = productItemCallback;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product_layout, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        ProductItem productItem = productItems.get(position);

        holder.lblProductTitle.setText(productItem.getTitle());
        holder.lblProductPrice.setText(PriceUtils.format(productItem.getPrice()));
        holder.lblProductDiscountPrice.setText(PriceUtils.calcDiscount(productItem.getPrice(),productItem.getDiscount()));


        Glide.with(holder.imgProductIcon.getContext())
                .load(productItem.getIcon())
                .into(holder.imgProductIcon);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productItemCallback.onBuyProductClick(view,productItem);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }

    public void setData(List<ProductItem> productItems) {
        this.productItems = productItems;
        notifyDataSetChanged();
    }

    public void clearAdapter() {
        productItems.clear();
        notifyDataSetChanged();
    }

    /**
     * ViewHolder class
     */
    public class ProductViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_product_icon)
        public ImageView imgProductIcon;
        @BindView(R.id.lbl_product_title)
        public TextView lblProductTitle;
        @BindView(R.id.lbl_product_price)
        public TextView lblProductPrice;
        @BindView(R.id.lbl_product_discount_price)
        public TextView lblProductDiscountPrice;

        public View itemView;

        public ProductViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.itemView = itemView;
        }
    }

}
