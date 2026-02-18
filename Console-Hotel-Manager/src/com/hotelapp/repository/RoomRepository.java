package com.hotelapp.repository;

import com.hotelapp.model.Room;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoomRepository {
    private List<Room> rooms;

    public RoomRepository() {
        this.rooms = new ArrayList<>();
        rooms.add(new Room("101", "Standard", 150.0));
        rooms.add(new Room("102", "Standard", 150.0));
        rooms.add(new Room("201", "Deluxe", 250.0));
        rooms.add(new Room("202", "Deluxe", 250.0));
        rooms.add(new Room("301", "Suite", 500.0));
    }


    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms);
    }

    public Optional<Room> findRoomById(String roomId) {
        for (Room room : rooms) {
            if (room.getRoomId().equalsIgnoreCase(roomId)) {
                return Optional.of(room);
            }
        }
        return Optional.empty();
    }
}