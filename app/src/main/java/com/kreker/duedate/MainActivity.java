package com.kreker.duedate;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    ListView listview;
    MyArrayAdapter studentArrayAdapter;
    ArrayList<DueDate> dueDateArray = new ArrayList<DueDate>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // inflate the array list with data
        dueDateArray.add(new DueDate("Nick", "18", "1st Street"));
        dueDateArray.add(new DueDate("John", "18", "2st Street"));
        dueDateArray.add(new DueDate("Anthony", "19", "3rd Street"));
        dueDateArray.add(new DueDate("James", "20", "5th Street"));
        dueDateArray.add(new DueDate("Jack", "20", "6th Street"));
        dueDateArray.add(new DueDate("Jeremy", "20", "7th Street"));
        dueDateArray.add(new DueDate("Long", "21", "1st Street"));

        // set the array adapter to use the above array list and tell the listview to set as the adapter
        // our custom adapter
        studentArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.list_item, dueDateArray);
        listview= (ListView) findViewById(R.id.listView);
        listview.setItemsCanFocus(false);
        listview.setAdapter(studentArrayAdapter);

        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    final int position, long id) {

                Toast.makeText(MainActivity.this,
                        "List Item Clicked:" + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

}