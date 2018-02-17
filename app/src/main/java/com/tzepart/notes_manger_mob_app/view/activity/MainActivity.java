package com.tzepart.notes_manger_mob_app.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tzepart.notes_manger_mob_app.App;
import com.tzepart.notes_manger_mob_app.view.adapter.NotesAdapter;
import com.tzepart.notes_manger_mob_app.R;
import com.tzepart.notes_manger_mob_app.model.NoteModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<NoteModel> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notes = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.notes_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerView.setAdapter(adapter);

        App.getApi().getData("bash", 50).enqueue(new Callback<List<NoteModel>>() {
            @Override
            public void onResponse(Call<List<NoteModel>> call, Response<List<NoteModel>> response) {
                notes.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<NoteModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
