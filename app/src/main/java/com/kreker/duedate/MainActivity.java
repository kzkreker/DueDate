package com.kreker.duedate;

import java.util.ArrayList;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
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
        dueDateArray.add(new DueDate("Date1", new Date()));
        dueDateArray.add(new DueDate("Date2", new Date()));
        dueDateArray.add(new DueDate("Date3", new Date()));
        dueDateArray.add(new DueDate("Date4", new Date()));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
}