
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
/**
 * Copyright 2017 Oryna Starkina
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */