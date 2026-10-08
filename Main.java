import java.util.Scanner;

/*
 * Author: Idrissa Traore
 * Email: itraore2@wisc.edu
 * Course: CS200, Fall 2025
 * Assignment: Project 1
 * Citations: https://stackoverflow.com/questions/70714514/
 * putting-variables-outside-of-mainstring-args-in-the-main-java-file
 */

/**
 * This class runs the two-player 4-in-a-row game on an 8×8 board.
 * Players take turns choosing a column, and their marker ("1" or "2")
 * is placed in the lowest available row of that column.
 *
 * The game ends when either player gets 4 markers in a row horizontally,
 * vertically, or diagonally.
 *
 * @author Idrissa Traore
 */
public class Main {
    public static void main(String[] args) {
        // Create the board object (instantiable class)
        Board board = new Board();

        // Print the initial empty board
        board.printNewBoard();
        board.playGame();
    }
}

/**
 * Represents the game board and contains all logic for playing the game.
 */
class Board {
    private String[][] board;
    private int rows = 8;
    private int cols = 8;

    /**
     * Initializes the game board, then alternates Player 1 and Player 2 turns for up to 64 total
     * moves (Total Amount of o's). After each move,
     * the method checks for a win.
     *
     * @param args command-line arguments (unused)
     */
    public void playGame() {
        Scanner scnr = new Scanner(System.in);

        // Game loop
        for (int i = 0; i < 64; i++) {
            // Player 1 move
            System.out.println("Player 1 -> What Column? (1-8)");
            int col1 = scnr.nextInt() - 1;
            int row1 = stackNumbers(col1);
            if (row1 >= 0) {
                placeMarker(row1, col1, "1");
            } else {
                System.out.println("Column full");
            }
            printNewBoard();
            if (checkWin("1")) {
                System.out.println("Player 1 has got 4 in a row. Player 1 Wins");
                break;
            }

            // Player 2 move
            System.out.println("Player 2 -> What Column? (1-8)");
            int col2 = scnr.nextInt() - 1;
            int row2 = stackNumbers(col2);
            if (row2 >= 0) {
                placeMarker(row2, col2, "2");
            } else {
                System.out.println("Column full");
            }
            printNewBoard();
            if (checkWin("2")) {
                System.out.println("Player 2 has got 4 in a row. Player 2 Wins");
                break;
            }
        }
        scnr.close();
    }

    /** Creates a board */
    public Board() {
        board = new String[rows][cols];
        createBoard();
    }

    /** Creates an empty board with "o"'s */
    public void createBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = "o";
            }
        }
    }

    /** Prints the current board after each turn */
    public void printNewBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    /** Finds the lowest available row in a column */
    public int stackNumbers(int column) {
        int row = rows - 1;
        while (row >= 0 && !board[row][column].equals("o")) {
            row--;
        }
        return row;
    }

    /** Places a marker (1 or 2) at the given position */
    public void placeMarker(int row, int col, String marker) {
        board[row][col] = marker;
    }

    /** Checks if the given marker has 4 in a row */
    public boolean checkWin(String marker) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j].equals(marker)) {
                    // Horizontal
                    if (j + 3 < cols &&
                            board[i][j + 1].equals(marker) &&
                            board[i][j + 2].equals(marker) &&
                            board[i][j + 3].equals(marker)) {
                        return true;
                    }

                    // Vertical
                    if (i + 3 < rows &&
                            board[i + 1][j].equals(marker) &&
                            board[i + 2][j].equals(marker) &&
                            board[i + 3][j].equals(marker)) {
                        return true;
                    }

                    // Diagonal right
                    if (i + 3 < rows && j + 3 < cols &&
                            board[i + 1][j + 1].equals(marker) &&
                            board[i + 2][j + 2].equals(marker) &&
                            board[i + 3][j + 3].equals(marker)) {
                        return true;
                    }

                    // Diagonal left
                    if (i + 3 < rows && j - 3 >= 0 &&
                            board[i + 1][j - 1].equals(marker) &&
                            board[i + 2][j - 2].equals(marker) &&
                            board[i + 3][j - 3].equals(marker)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
