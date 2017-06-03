package com.task.university;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class DateReservationActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView placeTextView;
    private String placeName, floorName;
    private List<Button> datesToReserve;
    private Random random;
    private Button setDate, reserve;
    private GregorianCalendar calendar;
    private SimpleDateFormat dateFormat;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_reservation);
        initializePlaceTextView();
        initializeDateToReserveList();
        setOccupiedDates();
        setListeners();
        reserve = (Button) findViewById(R.id.reserveButton);
        reserve.setOnClickListener(this);
        calendar = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    }

    private void setListeners() {
        for (Button date : datesToReserve) {
            date.setOnClickListener(this);
        }
    }

    private void setOccupiedDates() {
        random = new Random();
        int count = random.nextInt(8) + 1;
        int index;
        for (int i = 0; i < count; i++) {
            index = random.nextInt(datesToReserve.size());
            datesToReserve.get(index).setBackgroundColor(Color.GRAY);
            datesToReserve.get(index).setEnabled(false);
            datesToReserve.get(index).setTextColor(Color.WHITE);
        }
    }

    private void initializeDateToReserveList() {
        datesToReserve = new ArrayList<>();
        datesToReserve.add((Button) findViewById(R.id.nineToday));
        datesToReserve.add((Button) findViewById(R.id.tenToday));
        datesToReserve.add((Button) findViewById(R.id.elevenToday));
        datesToReserve.add((Button) findViewById(R.id.twelveToday));
        datesToReserve.add((Button) findViewById(R.id.thirteenToday));
        datesToReserve.add((Button) findViewById(R.id.fourteenToday));
        datesToReserve.add((Button) findViewById(R.id.nineTomorrow));
        datesToReserve.add((Button) findViewById(R.id.tenTomorrow));
        datesToReserve.add((Button) findViewById(R.id.elevenTomorrow));
        datesToReserve.add((Button) findViewById(R.id.twelveTomorrow));
        datesToReserve.add((Button) findViewById(R.id.thirteenTomorrow));
        datesToReserve.add((Button) findViewById(R.id.fourteenTomorrow));
    }

    private void initializePlaceTextView() {
        placeTextView = (TextView) findViewById(R.id.placeTextView);
        placeName = "Place " + getIntent().getStringExtra("Number");
        floorName = getIntent().getStringExtra("StockName");
        placeTextView.setText(placeName);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.reserveButton) {
            if (setDate != null) {
                Intent intent = new Intent(this, MenuActivity.class);
                Utils.getInstance().reservations.add(new Reservation(floorName, placeName,
                        "Period: " + setDate.getText().toString(), "Date: " + dateFormat.format(date)));
                startActivity(intent);
                finishActivity(0);
            }
        }
        else {
            if (setDate != null) {
                setDate.setBackgroundColor(0xE9F1FE);
                setDate.setTextColor(Color.BLACK);
                setDate.setEnabled(true);
            }
            Button clicked = (Button) view;
            for (int i = 0; i < 6; i++) {
                if (clicked == datesToReserve.get(i)) {
                    clicked.setBackgroundColor(Color.GRAY);
                    clicked.setTextColor(Color.WHITE);
                    clicked.setEnabled(false);
                    setDate = clicked;
                    date = calendar.getTime();
                    return;
                }
            }
            clicked.setBackgroundColor(Color.GRAY);
            clicked.setTextColor(Color.WHITE);
            clicked.setEnabled(false);
            setDate = clicked;
            date = new Date();
            date.setTime(calendar.getTimeInMillis() + 86400000);
        }
    }
}
