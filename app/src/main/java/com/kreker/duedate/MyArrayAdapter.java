package com.kreker.duedate;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.ArrayList;

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
        StudentWrapper StudentWrapper = null;

        if (item == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            item = inflater.inflate(layoutResourceId, parent, false);
            StudentWrapper = new StudentWrapper();
            StudentWrapper.name = (TextView) item.findViewById(R.id.textName);
            StudentWrapper.age = (TextView) item.findViewById(R.id.textAge);
            StudentWrapper.address = (TextView) item.findViewById(R.id.textAddr);
            StudentWrapper.edit = (Button) item.findViewById(R.id.btnEdit);
            StudentWrapper.delete = (Button) item.findViewById(R.id.btnDelete);
            item.setTag(StudentWrapper);
        } else {
            StudentWrapper = (StudentWrapper) item.getTag();
        }

        DueDate dueDate = dueDates.get(position);
        StudentWrapper.name.setText(dueDate.getName());
        StudentWrapper.age.setText(dueDate.getAge());
        StudentWrapper.address.setText(dueDate.getAddress());

        StudentWrapper.edit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Edit", Toast.LENGTH_LONG).show();
            }
        });

        StudentWrapper.delete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Delete", Toast.LENGTH_LONG).show();
            }
        });

        return item;

    }

    static class StudentWrapper {
        TextView name;
        TextView age;
        TextView address;
        Button edit;
        Button delete;
    }

}