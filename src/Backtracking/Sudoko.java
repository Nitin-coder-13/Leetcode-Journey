package Backtracking;

import java.util.*;

public class Sudoko {
    public static void main(String[] args) {
        char[][] board = {{5, 3, 0, 0, 7, 0, 0, 0, 0}, {6, 0, 0, 1, 9, 5, 0, 0, 0}, {0, 9, 8, 0, 0, 0, 0, 6, 0}, {8, 0, 0, 0, 6, 0, 0, 0, 3}, {4, 0, 0, 8, 0, 3, 0, 0, 1}, {7, 0, 0, 0, 2, 0, 0, 0, 6}, {0, 6, 0, 0, 0, 0, 2, 8, 0}, {0, 0, 0, 4, 1, 9, 0, 0, 5}, {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        sudoko_game(board, 0, 0);
    }

    public static void sudoko_game(char[][] board, int current_row, int current_col) {
        if (current_col == board.length) {
            current_col = 0;
            current_row++;
        }
        if (current_row == board.length) {
            Display(board);
            return;
        }
        // 0 matlab unfilled hai
        if (board[current_row][current_col] != 0) {
            sudoko_game(board, current_row, current_col + 1);
        } else {
            for (char value = 1; value <= 9; value++) {
                if (is_it_safe(board, current_row, current_col, value)) {
                    board[current_row][current_col] = value; // waha baitha do uss value ko
                    sudoko_game(board, current_row, current_col + 1);
                    board[current_row][current_col] = 0; // backtracking step
                }
            }
        }

    }

    // main part
    public static boolean is_it_safe(char[][] board, int current_row, int current_col, int value) {
        // checking for row validation (column will vary)
        for (int col = 0; col < board[0].length; col++) {
            if (board[current_row][col] == value) {
                return false;
            }
        }
        // checking for column validation (row will vary)
        for (int row = 0; row < board.length; row++) {
            if (board[row][current_col] == value) {
                return false;
            }
        }
        // for 3X3 matrix validation
        int matrix_start_row = current_row - (current_row % 3);// starting co-ordinate for row
        int matrix_start_col = current_col - (current_col % 3);// starting co-ordinate for columns
        for (int i = matrix_start_row; i < matrix_start_row + 3; i++) {
            for (int j = matrix_start_col; j < matrix_start_col + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void Display(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
