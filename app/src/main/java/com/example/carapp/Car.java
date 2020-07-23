package com.example.carapp;

public class Car {

//    private int mImageDrawable;
    private String name;
    private String distance;
//    private String fuel;
//    private String consumption;

    //(int mImageDrawable, String name, String distance, String fuel, String consumption)

    public Car(String name) {
//        this.mImageDrawable = mImageDrawable;
        this.name = name;
        this.distance = distance;
//        this.fuel = fuel;
//        this.consumption = consumption;
    }

//    public int getmImageDrawable() {
//        return mImageDrawable;
//    }
//
//    public void setmImageDrawable(int mImageDrawable) {
//        this.mImageDrawable = mImageDrawable;
//    }
//
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
//
//    public String getFuel() {
//        return fuel;
//    }
//
//    public void setFuel(String fuel) {
//        this.fuel = fuel;
//    }
//
//    public String getConsumption() {
//        return consumption;
//    }
//
//    public void setConsumption(String consumption) {
//        this.consumption = consumption;
//    }
}
