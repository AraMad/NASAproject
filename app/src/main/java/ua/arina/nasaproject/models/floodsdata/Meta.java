
package ua.arina.nasaproject.models.floodsdata;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("licence")
    @Expose
    private String licence;
    @SerializedName("documentation")
    @Expose
    private String documentation;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("hasFormat")
    @Expose
    private List<String> hasFormat = null;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getHasFormat() {
        return hasFormat;
    }

    public void setHasFormat(List<String> hasFormat) {
        this.hasFormat = hasFormat;
    }

}
