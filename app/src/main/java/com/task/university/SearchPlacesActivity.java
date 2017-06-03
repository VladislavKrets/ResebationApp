package com.task.university;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class SearchPlacesActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonStock1, buttonStock2, buttonStock3;
    private TextView occupiedStock1, occupiedStock2, occupiedStock3,
    freeStock1, freeStock2, freeStock3;
    private int freePlacesStock1, freePlacesStock2, freePlacesStock3;
    private int occupiedPlacesStock1, occupiedPlacesStock2, occupiedPlacesStock3;
    private Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_places);
        initializeWidgets();
        random = new Random();
        calculatePlaces();
        settingValues();
    }

    private void settingValues() {
        occupiedStock1.setText(String.valueOf(occupiedPlacesStock1));
        occupiedStock2.setText(String.valueOf(occupiedPlacesStock2));
        occupiedStock3.setText(String.valueOf(occupiedPlacesStock3));
        freeStock1.setText(String.valueOf(freePlacesStock1));
        freeStock2.setText(String.valueOf(freePlacesStock2));
        freeStock3.setText(String.valueOf(freePlacesStock3));
    }

    private void calculatePlaces() {
        freePlacesStock1 = random.nextInt(33) + 1;
        freePlacesStock2 = random.nextInt(33) + 1;
        freePlacesStock3 = random.nextInt(33) + 1;
        occupiedPlacesStock1 = 33 - freePlacesStock1;
        occupiedPlacesStock2 = 33 - freePlacesStock2;
        occupiedPlacesStock3 = 33 - freePlacesStock3;
    }

    private void initializeWidgets() {
        buttonStock1 = (Button) findViewById(R.id.buttonStock1);
        buttonStock1.setOnClickListener(this);
        buttonStock2 = (Button) findViewById(R.id.buttonStock2);
        buttonStock2.setOnClickListener(this);
        buttonStock3 = (Button) findViewById(R.id.buttonStock3);
        buttonStock3.setOnClickListener(this);
        occupiedStock1 = (TextView) findViewById(R.id.occupiedStockOne);
        occupiedStock2 = (TextView) findViewById(R.id.occupiedStockTwo);
        occupiedStock3 = (TextView) findViewById(R.id.occupiedStockThree);
        freeStock1 = (TextView) findViewById(R.id.freeStockOne);
        freeStock2 = (TextView) findViewById(R.id.freeStockTwo);
        freeStock3 = (TextView) findViewById(R.id.freeStockThree);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonStock1: {
                Intent intent = new Intent(this, StockActivity.class);
                intent.putExtra("free", freePlacesStock1);
                intent.putExtra("occupied", occupiedPlacesStock1);
                intent.putExtra("stockName", "Floor1");
                startActivity(intent);
                break;
            }
            case R.id.buttonStock2: {
                Intent intent = new Intent(this, StockActivity.class);
                intent.putExtra("free", freePlacesStock2);
                intent.putExtra("occupied", occupiedPlacesStock2);
                intent.putExtra("stockName", "Floor2");
                startActivity(intent);
                break;
            }
            case R.id.buttonStock3: {
                Intent intent = new Intent(this, StockActivity.class);
                intent.putExtra("free", freePlacesStock3);
                intent.putExtra("occupied", occupiedPlacesStock3);
                intent.putExtra("stockName", "Floor3");
                startActivity(intent);
                break;
            }
        }
    }
}
