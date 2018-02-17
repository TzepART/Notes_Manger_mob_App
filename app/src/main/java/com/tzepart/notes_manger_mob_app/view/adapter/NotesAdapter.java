package com.tzepart.notes_manger_mob_app.view.adapter;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tzepart.notes_manger_mob_app.R;
import com.tzepart.notes_manger_mob_app.model.NoteModel;

import java.util.List;

/**
 * Created by misha on 31.10.2016.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<NoteModel> notes;

    public NotesAdapter(List<NoteModel> notes) {
        this.notes = notes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NoteModel note = notes.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.note.setText(Html.fromHtml(note.getElementPureHtml(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.note.setText(Html.fromHtml(note.getElementPureHtml()));
        }
        holder.site.setText(note.getSite());
    }

    @Override
    public int getItemCount() {
        if (notes == null)
            return 0;
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView note;
        TextView site;

        public ViewHolder(View itemView) {
            super(itemView);
            note = (TextView) itemView.findViewById(R.id.noteitem_note);
            site = (TextView) itemView.findViewById(R.id.noteitem_site);
        }
    }
}
