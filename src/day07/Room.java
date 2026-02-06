package day07;

public class Room {
        private final String roomNumber;
        private final double pricePerNight;
        private String guestName;
        private boolean isBooked;

        public Room(String roomNumber, double pricePerNight) {
            this.roomNumber = roomNumber;
            if (pricePerNight < 0) {
                this.pricePerNight = 0;
                System.out.println("Error: Price cannot be negative. Set to 0.");
            } else {
                this.pricePerNight = pricePerNight;
            }
            this.guestName = null;
            this.isBooked = false;
        }


    public void checkIn(String guestName) {
        if (this.isBooked) {
            System.out.println("Error: Room " + this.roomNumber + " is already occupied by " + this.guestName);
        } else {
            this.guestName = guestName;
            this.isBooked = true;
            System.out.println("Success: " + guestName + " checked into Room " + this.roomNumber);
        }
    }

    public void checkOut() {
        if (!this.isBooked) {
            System.out.println("Error: Room " + this.roomNumber + " is already empty.");
        } else {
            System.out.println("Success: " + this.guestName + " checked out.");
            this.guestName = null;
            this.isBooked = false;
        }
    }


    public String getRoomInfo() {
        // Ternary operator: If occupied, show guest name. If not, show "Available"
        String statusStr = this.isBooked ? "Occupied (" + this.guestName + ")" : "Available";

        return String.format("Room: %s | Price: $%.2f | Status: %s",
                this.roomNumber, this.pricePerNight, statusStr);
    }


    public String getRoomNumber() { return roomNumber; }
    public double getPricePerNight() { return pricePerNight; }


    }

