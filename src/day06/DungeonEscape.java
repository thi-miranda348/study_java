package day06;

import java.util.Arrays;
import java.util.Scanner;

public class DungeonEscape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Setup variables
        char[][] board = new char[5][5];
        int pRow = 0; // Player Row starts at 0
        int pCol = 0; // Player Col starts at 0

        // Fill board with dots '.'
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        // Set specific spots
        board[0][0] = 'P'; // Player
        board[4][4] = 'T'; // Treasure
        board[2][2] = 'X'; // Trap 1
        board[1][3] = 'X'; // Trap 2

        System.out.println("--- DUNGEON ESCAPE START ---");

        // GAME LOOP
        while (true) {
            // Draw Map
            System.out.println("\nMap:");
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println(); // New line after each row
            }

            // Get Input
            System.out.print("Move W-Up; A-Left; S-Down; D-Right (WASD): ");
            char move = scanner.next().charAt(0); // Get first char

            // Calculate New Coordinates (Hypothetical)
            int newRow = pRow;
            int newCol = pCol;


            if (move == 'W' || move == 'w') {
                newRow--;
            } else if (move == 'S' || move == 's') {
                newRow++;
            } else if (move == 'A' || move == 'a') {
                newCol--;
            } else if (move == 'D' || move == 'd') {
                newCol++;
            } else {
                System.out.println("Invalid move! Use W, A, S, D.");
                continue;
            }


            // Check Boundaries (Walls)
            if (newRow < 0 || newRow > 4 || newCol < 0 || newCol > 4) {
                System.out.println("OUCH! You hit a wall!");
                continue; // Skip the rest, restart loop
            }

            // E. Check Content of New Spot
            char targetSpot = board[newRow][newCol];

            if (targetSpot == 'T') {
                System.out.println("YOU WIN! Found the treasure!");
                break;
            } else if (targetSpot == 'X') {
                System.out.println("GAME OVER! You fell into a trap!");
                break;
            }

            // F. Actual Move (Update Board)
            board[pRow][pCol] = '.';
            pRow = newRow;
            pCol = newCol;
            board[pRow][pCol] = 'P';
        }

        scanner.close();
    }
}