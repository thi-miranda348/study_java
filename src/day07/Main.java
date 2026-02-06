package day07;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- 1. Creating Room Objects ---");
        Room room101 = new Room("101", 150.00);
        Room room202 = new Room("202", -200.00);


        System.out.println("\n--- 2. Initial Status ---");
        System.out.println(room101.getRoomInfo());
        System.out.println(room202.getRoomInfo());


        System.out.println("\n--- 3. Checking Alice into Room 101 ---");
        room101.checkIn("Alice");

        System.out.println(room101.getRoomInfo());


        System.out.println("\n--- 4. Testing Double Booking (Bob) ---");
        room101.checkIn("Bob");


        System.out.println("\n--- 5. Checking Out ---");
        room101.checkOut();
        System.out.println(room101.getRoomInfo());


        System.out.println("\n--- 6. Checking Bob in again ---");
        room101.checkIn("Bob");
        System.out.println(room101.getRoomInfo());
    }
}