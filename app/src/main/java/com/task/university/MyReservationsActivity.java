package com.task.university;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MyReservationsActivity extends AppCompatActivity {
    private MyReservationsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);
        adapter = new MyReservationsAdapter(this, Utils.getInstance().reservations);
        ListView listView = (ListView) findViewById(R.id.reservations);
        listView.setAdapter(adapter);
    }
}
