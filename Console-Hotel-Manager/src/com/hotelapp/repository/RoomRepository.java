package com.hotelapp.repository;

import com.hotelapp.model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private List<Room> rooms = new ArrayList<>();


    public RoomRepository() {
        rooms.add(new Room("101", "Standard", 100.0));
        rooms.add(new Room("102", "Standard", 100.0));
        rooms.add(new Room("201", "Deluxe", 200.0));
        rooms.add(new Room("202", "Deluxe", 200.0));
        rooms.add(new Room("301", "Suite", 500.0));

        System.out.println("-> [Repo] Database loaded with " + rooms.size() + " rooms.");
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public Room getRoomById(String id) {
        for (Room room : rooms) {
            if (room.getRoomId().equalsIgnoreCase(id)) {
                return room;
            }
        }
        return null;
    }

}