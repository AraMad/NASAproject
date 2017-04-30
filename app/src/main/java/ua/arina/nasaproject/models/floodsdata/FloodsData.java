
package ua.arina.nasaproject.models.floodsdata;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FloodsData {

    @SerializedName("@context")
    @Expose
    private String context;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
