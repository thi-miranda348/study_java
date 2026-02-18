package com.hotelapp.ui;

import com.hotelapp.service.HotelService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HotelService hotelService = new HotelService();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("==========================================");
        System.out.println("   🏨 WELCOME TO LANDON HOTEL MANAGER     ");
        System.out.println("==========================================");


        while (isRunning) {
            printMenu();


            int choice = -1;
            try {
                System.out.print("👉 Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    hotelService.displayHotelStatus();
                    break;

                case 2:
                    System.out.println("\n--- 📥 CHECK-IN FORM ---");
                    System.out.print("Enter Room Number (e.g., 101): ");
                    String inRoomId = scanner.nextLine();

                    System.out.print("Enter Guest Name: ");
                    String guestName = scanner.nextLine();

                    System.out.print("Enter Guest Email: ");
                    String guestEmail = scanner.nextLine();


                    hotelService.checkIn(inRoomId, guestName, guestEmail);
                    break;

                case 3:
                    System.out.println("\n--- 📤 CHECK-OUT FORM ---");
                    System.out.print("Enter Room Number to check-out: ");
                    String outRoomId = scanner.nextLine();


                    hotelService.checkOut(outRoomId);
                    break;

                case 4:
                    System.out.println("\n--- 🔎 FIND GUEST ---");
                    System.out.print("Enter Guest Name to search: ");
                    String searchName = scanner.nextLine();
                    hotelService.findGuestByName(searchName);
                    break;

                case 0:
                    System.out.println("👋 Exiting system. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("❌ Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n------------------------------------------");
        System.out.println("1. 📋 View All Rooms");
        System.out.println("2. 📥 Check-in Guest");
        System.out.println("3. 📤 Check-out Guest");
        System.out.println("4. 🔎 Find Guest by Name");
        System.out.println("0. 🚪 Exit");
        System.out.println("------------------------------------------");
    }
}