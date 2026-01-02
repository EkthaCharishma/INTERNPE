import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (true) {

            printBoard();
            System.out.println("Player (X), enter row and column (1-3): ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid input! Use numbers between 1 and 3.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("Cell already occupied! Try again.");
                continue;
            }

            board[row][col] = 'X';

            if (checkWin('X')) {
                printBoard();
                System.out.println("Player wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }

            System.out.println("Computer's turn...");
            int r, c;
            do {
                r = rand.nextInt(3);
                c = rand.nextInt(3);
            } while (board[r][c] != ' ');

            board[r][c] = 'O';

            if (checkWin('O')) {
                printBoard();
                System.out.println("Computer wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("Game Draw!");
                break;
            }
        }
        sc.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player &&
                board[i][1] == player &&
                board[i][2] == player)
                return true;

            if (board[0][i] == player &&
                board[1][i] == player &&
                board[2][i] == player)
                return true;
        }

        if (board[0][0] == player &&
            board[1][1] == player &&
            board[2][2] == player)
            return true;

        if (board[0][2] == player &&
            board[1][1] == player &&
            board[2][0] == player)
            return true;

        return false;
    }

    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}