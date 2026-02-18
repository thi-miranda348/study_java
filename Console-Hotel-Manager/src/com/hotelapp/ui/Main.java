package com.hotelapp.ui;

import com.hotelapp.model.Guest;
import com.hotelapp.model.Room;

public class Main {
    public static void main(String[] args) {
        Guest g1 = new Guest(1, "Tony Stark", "ironman@avengers.com");

        Room r101 = new Room("101", "Deluxe", 500.0);

        System.out.println(r101);

        r101.setOccupant(g1);

        System.out.println(r101);

    }
}