package com.tzepart.notes_manger_mob_app;

import android.app.Application;

import com.tzepart.notes_manger_mob_app.api.NotesManagerApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by misha on 31.10.2016.
 */

public class App extends Application {

    private static NotesManagerApi notesManagerApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.tzepart_notes_manager.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        notesManagerApi = retrofit.create(NotesManagerApi.class);
    }

    public static NotesManagerApi getApi() {
        return notesManagerApi;
    }
}
