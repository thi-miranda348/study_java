package com.hotelapp.model;

public class Room {
    private String roomId;
    private String type;
    private double price;

    private Guest occupant;


    public Room(String roomId, String type, double price) {
        this.roomId = roomId;
        this.type = type;
        this.price = price;
        this.occupant = null;
    }


    public boolean isOccupied() {
        return this.occupant != null;
    }

    @Override
    public String toString() {
        String status = (occupant == null) ? "Available" : "Occupied by [" + occupant.getName() + "]";
        return String.format("Room %s (%s) - $%.2f - %s", roomId, type, price, status);
    }


    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }


    public Guest getOccupant() { return occupant; }
    public void setOccupant(Guest occupant) { this.occupant = occupant; }
}