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