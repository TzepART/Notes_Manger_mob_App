package com.tzepart.notes_manger_mob_app.api;

import com.tzepart.notes_manger_mob_app.model.NoteModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface NotesManagerApi {

    @GET("/api/get")
    Call<List<NoteModel>> getData(@Query("name") String resourceName, @Query("num") int count);
}
