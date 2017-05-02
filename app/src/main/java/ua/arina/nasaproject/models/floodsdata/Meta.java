
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
/**
 * Copyright 2017 Oryna Starkina
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    ttp://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */