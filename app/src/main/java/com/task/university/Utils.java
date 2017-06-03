package com.task.university;

import java.util.ArrayList;

/**
 * Created by lollipop on 03.06.2017.
 */

public class Utils {
    private static Utils instance;
    public ArrayList<Reservation> reservations;
    private Utils() {
        reservations = new ArrayList<>();
    }

    public static Utils getInstance() {
        if (instance == null) instance = new Utils();
        return instance;
    }
}
