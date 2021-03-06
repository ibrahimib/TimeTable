package com.ulan.timetable.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ulan.timetable.Model.Note;
import com.ulan.timetable.R;

import java.util.ArrayList;


/**
 * Created by Ulan on 28.09.2018.
 */
public class NotesListAdapter extends ArrayAdapter<Note> {

    private static final String TAG = "NotesListAdapter";
    private int mResource;
    private Context mContext;
    private ArrayList<Note> notelist;
    private Note note;

    private static class ViewHolder {
        TextView title;
    }

    public NotesListAdapter(Context context, int resource, ArrayList<Note> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
        this.notelist = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String title = getItem(position).getTitle();
        String text = getItem(position).getText();

        note = new Note(title, text);
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.titlenote);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(note.getTitle());
        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public ArrayList<Note> getNotelist() {
        return notelist;
    }

    public Note getNote() {
        return note;
    }
}
