package com.tzepart.notes_manger_mob_app.api;

import com.tzepart.notes_manger_mob_app.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by misha on 31.10.2016.
 */
public interface UmoriliApi {

    @GET("/api/get")
    Call<List<PostModel>> getData(@Query("name") String resourceName, @Query("num") int count);
}
