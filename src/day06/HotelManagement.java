package day06;

import java.util.Scanner;

public class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set up the hotel size
        System.out.print("How many floors in your hotel: ");
        int floorCount = scanner.nextInt();

        System.out.print("How many rooms per floor: ");
        int roomCount = scanner.nextInt();

        // Init 2D Array [Rows][Cols]
        String[][] rooms = new String[floorCount][roomCount];

        // Main Loop
        while (true) {
            displayMenu();
            System.out.print("Select: ");
            int userOption = scanner.nextInt();
            scanner.nextLine();

            if (userOption == 1) {
                System.out.print("Which floor (0 - " + (floorCount - 1) + "): ");
                int userFloor = scanner.nextInt();

                System.out.print("Which room (0 - " + (roomCount - 1) + "): ");
                int userRoom = scanner.nextInt();

                scanner.nextLine();

                System.out.print("What is your name: ");
                String userName = scanner.nextLine();

                // Validation: Check if floor/room exists
                if (userFloor >= 0 && userFloor < floorCount && userRoom >= 0 && userRoom < roomCount) {
                    if (rooms[userFloor][userRoom] == null) {
                        rooms[userFloor][userRoom] = userName;
                        System.out.println("Success! Checked in " + userName);
                    } else {
                        System.out.println("Error: Room already occupied by " + rooms[userFloor][userRoom]);
                    }

                } else {
                    System.out.println("Invalid number");
                }
            } else if (userOption == 2) {
                System.out.println("\n--- HOTEL MAP ---");

                for (int i = floorCount - 1; i >= 0; i--) {
                    System.out.print("Floor " + i + ": ");
                    for (int j = 0; j < roomCount; j++) {
                        if (rooms[i][j] == null) {
                            System.out.print("[ ] ");
                        } else {
                            System.out.print("[" + rooms[i][j] + "] ");
                        }
                    }
                    System.out.println();
                }

            } else if (userOption == 3) {
                System.out.println("Goodbye!");
                break;
            }

        }
        scanner.close();

    }
    public static void displayMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Check-In");
        System.out.println("2. View Map");
        System.out.println("3. Exit");
    }
}
