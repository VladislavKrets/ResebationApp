package com.task.university;

/**
 * Created by lollipop on 03.06.2017.
 */

public class Reservation {
    private String floor;
    private String period;
    private String placeName;
    private String date;

    public Reservation(String floor, String period, String placeName, String date) {
        this.floor = floor;
        this.period = period;
        this.placeName = placeName;
        this.date = date;
    }

    public String getFloor() {
        return floor;
    }

    public String getPeriod() {
        return period;
    }

    public String getDate() {
        return date;
    }

    public String getPlaceName() {
        return placeName;
    }
}
