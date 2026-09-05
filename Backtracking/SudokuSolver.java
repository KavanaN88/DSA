package Backtracking;
public class SudokuSolver {

    public static void main(String[] args) {

        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println("Sudoku Puzzle:");
        printBoard(board);

        if (solve(board)) {
            System.out.println("\nSolved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    // Finds the first empty cell
    public static int[] findEmptyCell(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    return new int[]{row, col};
                }
            }
        }

        return null;
    }

    // Checks whether the number already exists in the row
    public static boolean checkRow(char[][] board, int row, char number) {

        for (int col = 0; col < 9; col++) {

            if (board[row][col] == number) {
                return false;
            }
        }

        return true;
    }

    // Checks whether the number already exists in the column
    public static boolean checkColumn(char[][] board, int col, char number) {

        for (int row = 0; row < 9; row++) {

            if (board[row][col] == number) {
                return false;
            }
        }

        return true;
    }

    // Checks whether the number already exists in the 3x3 box
    public static boolean checkBox(char[][] board, int row, int col, char number) {

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {

            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    // Combines row, column, and box validation
    public static boolean canPlace(char[][] board, int row, int col, char number) {

        return checkRow(board, row, number)
                && checkColumn(board, col, number)
                && checkBox(board, row, col, number);
    }

    // Solves Sudoku using Backtracking
    public static boolean solve(char[][] board) {

        // Find an empty cell
        int[] emptyCell = findEmptyCell(board);

        // No empty cells means Sudoku is solved
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        // Try numbers from 1 to 9
        for (char number = '1'; number <= '9'; number++) {

            // Check whether the number can be placed
            if (canPlace(board, row, col, number)) {

                // Choose
                board[row][col] = number;

                // Explore
                if (solve(board)) {
                    return true;
                }

                // Backtrack
                board[row][col] = '.';
            }
        }

        return false;
    }

    // Prints the Sudoku board
    public static void printBoard(char[][] board) {

        for (int row = 0; row < 9; row++) {

            if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }

            for (int col = 0; col < 9; col++) {

                if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }

                System.out.print(board[row][col] + " ");
            }

            System.out.println();
        }
    }
}