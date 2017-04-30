
package ua.arina.nasaproject.models.floodsdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FloodArea {

    @SerializedName("@id")
    @Expose
    private String id;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("notation")
    @Expose
    private String notation;
    @SerializedName("polygon")
    @Expose
    private String polygon;
    @SerializedName("riverOrSea")
    @Expose
    private String riverOrSea;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getPolygon() {
        return polygon;
    }

    public void setPolygon(String polygon) {
        this.polygon = polygon;
    }

    public String getRiverOrSea() {
        return riverOrSea;
    }

    public void setRiverOrSea(String riverOrSea) {
        this.riverOrSea = riverOrSea;
    }

}
