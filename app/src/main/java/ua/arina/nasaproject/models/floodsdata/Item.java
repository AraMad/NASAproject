
package ua.arina.nasaproject.models.floodsdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("@id")
    @Expose
    private String id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("eaAreaName")
    @Expose
    private String eaAreaName;
    @SerializedName("eaRegionName")
    @Expose
    private String eaRegionName;
    @SerializedName("floodArea")
    @Expose
    private FloodArea floodArea;
    @SerializedName("floodAreaID")
    @Expose
    private String floodAreaID;
    @SerializedName("isTidal")
    @Expose
    private Boolean isTidal;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("severity")
    @Expose
    private String severity;
    @SerializedName("severityLevel")
    @Expose
    private Integer severityLevel;
    @SerializedName("timeMessageChanged")
    @Expose
    private String timeMessageChanged;
    @SerializedName("timeRaised")
    @Expose
    private String timeRaised;
    @SerializedName("timeSeverityChanged")
    @Expose
    private String timeSeverityChanged;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEaAreaName() {
        return eaAreaName;
    }

    public void setEaAreaName(String eaAreaName) {
        this.eaAreaName = eaAreaName;
    }

    public String getEaRegionName() {
        return eaRegionName;
    }

    public void setEaRegionName(String eaRegionName) {
        this.eaRegionName = eaRegionName;
    }

    public FloodArea getFloodArea() {
        return floodArea;
    }

    public void setFloodArea(FloodArea floodArea) {
        this.floodArea = floodArea;
    }

    public String getFloodAreaID() {
        return floodAreaID;
    }

    public void setFloodAreaID(String floodAreaID) {
        this.floodAreaID = floodAreaID;
    }

    public Boolean getIsTidal() {
        return isTidal;
    }

    public void setIsTidal(Boolean isTidal) {
        this.isTidal = isTidal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Integer getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(Integer severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getTimeMessageChanged() {
        return timeMessageChanged;
    }

    public void setTimeMessageChanged(String timeMessageChanged) {
        this.timeMessageChanged = timeMessageChanged;
    }

    public String getTimeRaised() {
        return timeRaised;
    }

    public void setTimeRaised(String timeRaised) {
        this.timeRaised = timeRaised;
    }

    public String getTimeSeverityChanged() {
        return timeSeverityChanged;
    }

    public void setTimeSeverityChanged(String timeSeverityChanged) {
        this.timeSeverityChanged = timeSeverityChanged;
    }

}
