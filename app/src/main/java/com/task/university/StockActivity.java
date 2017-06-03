package com.task.university;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockActivity extends AppCompatActivity implements View.OnClickListener {
    private int freePlaces;
    private int occupiedPlaces;
    private String stockName;
    private TextView stocktextView;
    private List<Button> places;
    private Random random;
    private Button setButton, reserveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        getValuesFromIntent();
        stocktextView = (TextView) findViewById(R.id.stockNameTextView);
        stocktextView.setText(stockName);
        initializePlaces();
        random = new Random();
        initializeOccupiedPlaces();
        setListeners();
        reserveButton = (Button) findViewById(R.id.buttonReserve);
        reserveButton.setOnClickListener(this);

    }

    private void setListeners() {
        for (Button place : places) {
            place.setOnClickListener(this);
        }
    }

    private void initializeOccupiedPlaces() {
        int index;
        for (int i = 0; i < occupiedPlaces; i++) {
            index = random.nextInt(places.size());
            places.get(index).setBackgroundColor(Color.BLACK);
            places.get(index).setEnabled(false);
            places.get(index).setTextColor(Color.WHITE);
        }
    }

    private void initializePlaces() {
        places = new ArrayList<>();
        places.add((Button) findViewById(R.id.p1));
        places.add((Button) findViewById(R.id.p2));
        places.add((Button) findViewById(R.id.p3));
        places.add((Button) findViewById(R.id.p4));
        places.add((Button) findViewById(R.id.p6));
        places.add((Button) findViewById(R.id.p7));
        places.add((Button) findViewById(R.id.p8));
        places.add((Button) findViewById(R.id.p9));
        places.add((Button) findViewById(R.id.p10));
        places.add((Button) findViewById(R.id.p11));
        places.add((Button) findViewById(R.id.p12));
        places.add((Button) findViewById(R.id.p13));
        places.add((Button) findViewById(R.id.p14));
        places.add((Button) findViewById(R.id.p15));
        places.add((Button) findViewById(R.id.p16));
        places.add((Button) findViewById(R.id.p17));
        places.add((Button) findViewById(R.id.p18));
        places.add((Button) findViewById(R.id.p19));
        places.add((Button) findViewById(R.id.p20));
        places.add((Button) findViewById(R.id.p21));
        places.add((Button) findViewById(R.id.p22));
        places.add((Button) findViewById(R.id.p23));
        places.add((Button) findViewById(R.id.p24));
        places.add((Button) findViewById(R.id.p25));
        places.add((Button) findViewById(R.id.p26));
        places.add((Button) findViewById(R.id.p27));
        places.add((Button) findViewById(R.id.p28));
        places.add((Button) findViewById(R.id.p29));
        places.add((Button) findViewById(R.id.p30));
        places.add((Button) findViewById(R.id.p31));
        places.add((Button) findViewById(R.id.p32));
        places.add((Button) findViewById(R.id.p33));
    }

    private void getValuesFromIntent() {
        Intent intent = getIntent();
        freePlaces = intent.getIntExtra("free", 0);
        occupiedPlaces = intent.getIntExtra("occupied", 1);
        stockName = intent.getStringExtra("stockName");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonReserve) {
            if (setButton != null) {
                Intent intent = new Intent(this, DateReservationActivity.class);
                intent.putExtra("Number", setButton.getText());
                intent.putExtra("StockName", stockName);
                startActivity(intent);
            }
            else return;
        }
        else {
            if (setButton != null) {
                setButton.setBackgroundColor(Color.WHITE);
                setButton.setTextColor(Color.BLACK);
                setButton.setEnabled(true);
            }
            Button clicked = (Button) view;
            clicked.setBackgroundColor(Color.BLACK);
            clicked.setTextColor(Color.WHITE);
            clicked.setEnabled(false);
            setButton = clicked;
        }
    }
}
