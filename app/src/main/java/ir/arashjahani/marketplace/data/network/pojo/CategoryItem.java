
package ir.arashjahani.marketplace.data.network.pojo;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CategoryItem {

    @SerializedName("icon")
    private String mIcon;
    @SerializedName("id")
    private Integer mId;
    @SerializedName("title")
    private String mTitle;

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

}
