
package ir.arashjahani.marketplace.data.network.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@SuppressWarnings("unused")
public class ProductItem implements Serializable {

    @SerializedName("cat_id")
    private String mCatId;
    @SerializedName("discount")
    private Integer mDiscount;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("id")
    private Long mId;
    @SerializedName("price")
    private Long mPrice;
    @SerializedName("title")
    private String mTitle;

    public String getCatId() {
        return mCatId;
    }

    public void setCatId(String catId) {
        mCatId = catId;
    }

    public Integer getDiscount() {
        return mDiscount;
    }

    public void setDiscount(Integer discount) {
        mDiscount = discount;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
