package com.kreker.duedate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by kreker on 30.08.15.
 */
public class MyArrayAdapter extends ArrayAdapter<DueDate> {

    Context context;
    int layoutResourceId;
    ArrayList<DueDate> dueDates = new ArrayList<DueDate>();

    public MyArrayAdapter(Context context, int layoutResourceId,
                          ArrayList<DueDate> studs) {
        super(context, layoutResourceId, studs);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.dueDates = studs;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        DueDateWrapper dueDateWrapper = null;

        if (item == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            item = inflater.inflate(layoutResourceId, parent, false);
            dueDateWrapper = new DueDateWrapper();
            dueDateWrapper.name = (TextView) item.findViewById(R.id.textName);
            dueDateWrapper.date = (TextView) item.findViewById(R.id.textDate);
            dueDateWrapper.edit = (ImageButton)item.findViewById(R.id.btnEdit);
            item.setTag(dueDateWrapper);
        } else {
            dueDateWrapper = (DueDateWrapper) item.getTag();
        }

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);

        DueDate dueDate = dueDates.get(position);
        dueDateWrapper.name.setText(dueDate.getName());
        dueDateWrapper.date.setText(df.format(dueDate.getDate()));

        dueDateWrapper.edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Edit", Toast.LENGTH_LONG).show();
            }
        });

        return item;

    }

    static class DueDateWrapper {
        TextView name;
        TextView date;
        ImageButton edit;
    }

}