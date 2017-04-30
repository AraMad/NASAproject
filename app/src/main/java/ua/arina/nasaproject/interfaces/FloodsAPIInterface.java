package ua.arina.nasaproject.interfaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ua.arina.nasaproject.models.floodsdata.FloodsData;

/**
 * Created by Arina on 29.04.2017
 */

public interface FloodsAPIInterface {

    @GET("flood-monitoring/id/floods")
    Call<String> getFloodsData(@Query("county") String c);

    @GET("flood-monitoring/id/floodAreas/{code}/polygon")
    Call<String> getGeoJSON(@Path("code") String code);
}
