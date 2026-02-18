package com.hotelapp.service;

import com.hotelapp.model.Guest;
import com.hotelapp.model.Room;
import com.hotelapp.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

public class HotelService {
    private RoomRepository roomRepository;
    private int guestIdCounter = 1;

    public HotelService() {
        this.roomRepository = new RoomRepository();
    }

    public void displayHotelStatus() {
        System.out.println("\n--- HOTEL STATUS ---");
        List<Room> rooms = roomRepository.getAllRooms();
        for (Room room : rooms) {
            System.out.println(room);
        }
        System.out.println("--------------------");
    }


    public boolean checkIn(String roomId, String guestName, String guestEmail) {

        Optional<Room> roomOpt = roomRepository.findRoomById(roomId);


        if (roomOpt.isEmpty()) {
            System.out.println("❌ Error: Room ID " + roomId + " not found.");
            return false;
        }

        Room room = roomOpt.get();
        if (room.isOccupied()) {
            System.out.println("❌ Error: Room " + roomId + " is already occupied.");
            return false;
        }


        Guest newGuest = new Guest(guestIdCounter++, guestName, guestEmail);
        room.setOccupant(newGuest);
        System.out.println("✅ Success: " + guestName + " has checked into Room " + roomId);
        return true;
    }


    public boolean checkOut(String roomId) {
        Optional<Room> roomOpt = roomRepository.findRoomById(roomId);

        if (roomOpt.isEmpty()) {
            System.out.println("❌ Error: Room ID " + roomId + " not found.");
            return false;
        }

        Room room = roomOpt.get();
        if (!room.isOccupied()) {
            System.out.println("❌ Error: Room " + roomId + " is already empty.");
            return false;
        }


        Guest guest = room.getOccupant();
        System.out.println("💰 Checkout Complete for " + guest.getName() + ". Total: $" + room.getPrice());

        room.setOccupant(null);
        return true;
    }


    public void findGuestByName(String nameToFind) {
        boolean found = false;
        for (Room room : roomRepository.getAllRooms()) {
            if (room.isOccupied() && room.getOccupant().getName().equalsIgnoreCase(nameToFind)) {
                System.out.println("🔎 FOUND: " + nameToFind + " is staying in Room " + room.getRoomId());
                found = true;
            }
        }
        if (!found) {
            System.out.println("⚠️ Guest '" + nameToFind + "' not found in the system.");
        }
    }
}