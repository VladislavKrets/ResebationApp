package com.task.university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{
    private Button searchPlacesButton, myReservationsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initializeButtons();
    }

    private void initializeButtons() {
        searchPlacesButton = (Button) findViewById(R.id.searchPlacesButton);
        searchPlacesButton.setOnClickListener(this);
        myReservationsButton = (Button) findViewById(R.id.myReservationsButton);
        myReservationsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.searchPlacesButton: {
                Intent intent = new Intent(this, SearchPlacesActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.myReservationsButton: {
                Intent intent = new Intent(this, MyReservationsActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
