package ir.arashjahani.marketplace.data.network.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created By ArashJahani on 05
 */
public class WrapperResponse<T> {

    @SerializedName("status")
    Responsestatus mStatus;

    @SerializedName("data")
    T mData;

    public Responsestatus getStatus() {
        return mStatus;
    }

    public void setStatus(Responsestatus mStatus) {
        this.mStatus = mStatus;
    }

    public T getData() {
        return mData;
    }

    public void setData(T mData) {
        this.mData = mData;
    }
}
