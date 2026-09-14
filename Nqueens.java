
import java.util.Scanner;

public class Nqueens {
    static int n;
    public static void PrintBoard(char[][] board) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean isSafe(char[][] board, int row, int col) {
        //Check column
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //Check upper-left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        //Check upper-right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void solve(char[][] board, int row) {
        //All queens placed
        if(row == n) {
            PrintBoard(board);
            return ;
        }
        for(int col=0; col<n; col++) {
            if(isSafe(board, row, col)){
                //Place queen
                board[row][col] = 'Q'; //Choose
                //Recursive call
                solve(board, row + 1); //Explore
                //Backtracking
                board[row][col] = '.'; //undo
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N : ");
        n = sc.nextInt();
        char[][] board = new char[n][n];
        //Initialize board
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        solve(board,0);
        sc.close();
    }
}
