package day05;

import java.util.Scanner;

public class MusicPlaylist {
    public static void main(String[] args) {
        String[] favoriteSongs = new String[5];
        Scanner scanner = new Scanner(System.in);


        while (true) {
            showMenu();

            System.out.print("Select: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();


            if (userInput == 1) {
                System.out.print("Enter the song name: ");
                String songName = scanner.nextLine();

                boolean added = false;

                for (int i = 0; i < favoriteSongs.length; i++) {
                    if (favoriteSongs[i] == null) {
                        favoriteSongs[i] = songName;
                        System.out.println("Success: Added '" + songName + "' to slot " + (i + 1));
                        added = true;
                        break;
                    }

                } if (!added) {

                    System.out.println("Error: Playlist is full");
                }

            } else if (userInput == 2) {
                System.out.println("--- CURRENT LIST ---");
                    boolean isEmpty = true;

                    for (String song: favoriteSongs) {
                        if (song != null) {
                            System.out.println("- " + song);
                            isEmpty = false;
                        }
                    }
                    if (isEmpty) {
                        System.out.println("Playlist is empty");
                    }
            } else if (userInput == 3) {
                System.out.print("Enter the keyword: ");
                String keyword = scanner.nextLine();
                boolean found = false;


                for (String song : favoriteSongs) {
                    if (song != null && song.toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println("Found: " + song);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No song matches '" + keyword + "'");
                }

            } else if (userInput == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }

        }
         scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n --- MY PLAYLIST ---");
        System.out.println("1. Add Song");
        System.out.println("2. View All");
        System.out.println("3. Search");
        System.out.println("4.Exit");

    }
}
