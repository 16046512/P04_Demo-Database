package com.example.a16046512.demodatabase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task>{
    private ArrayList<Task> task;
    private Context context;
    private TextView tvid,tvdes,tvdate;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvid = (TextView) rowView.findViewById(R.id.tvid);
        tvdes = (TextView) rowView.findViewById(R.id.tvdescription);
        tvdate = (TextView) rowView.findViewById(R.id.tvdate);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task currentTask = task.get(position);
        // Set the TextView to show the food

        tvid.setText(Integer.toString(currentTask.getId()));
        tvdes.setText(currentTask.getDescription());
        tvdate.setText(currentTask.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}


