package com.task.university;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lollipop on 03.06.2017.
 */

public class MyReservationsAdapter extends BaseAdapter {
    private Context ctx;
    private LayoutInflater lInflater;
    private ArrayList<Reservation> objects;

    public MyReservationsAdapter(Context context, ArrayList<Reservation> reservations) {
        ctx = context;
        objects = reservations;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }
        Reservation p = getReservation(position);

        ((TextView) view.findViewById(R.id.dateTextView)).setText(p.getDate());
        ((TextView) view.findViewById(R.id.periodTextView)).setText(p.getPeriod());
        ((TextView) view.findViewById(R.id.placeTextView)).setText(p.getPlaceName());
        ((TextView) view.findViewById(R.id.floorTextView)).setText(p.getFloor());

        return view;
    }

    Reservation getReservation(int position) {
        return ((Reservation) getItem(position));
    }


}

