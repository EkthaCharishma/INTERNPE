import java.util.Scanner;

public class ConnectFour {

    static final int ROWS = 6;
    static final int COLS = 7;
    static char[][] board = new char[ROWS][COLS];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playerOneTurn = true;
        boolean gameRunning = true;

        initializeBoard();

        System.out.println("=== CONNECT FOUR (Console Version) ===");

        while (gameRunning) {
            printBoard();
            char currentPlayer = playerOneTurn ? 'X' : 'O';

            System.out.print("Player " + currentPlayer + " - Choose column (0-6): ");
            int col = sc.nextInt();

            if (col < 0 || col >= COLS || !dropDisc(col, currentPlayer)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " WINS!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a DRAW!");
                break;
            }

            playerOneTurn = !playerOneTurn;
        }

        sc.close();
    }

    static void initializeBoard() {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                board[r][c] = '.';
            }
        }
    }

    static void printBoard() {
        System.out.println();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("0 1 2 3 4 5 6\n");
    }

    static boolean dropDisc(int col, char player) {
        for (int r = ROWS - 1; r >= 0; r--) {
            if (board[r][col] == '.') {
                board[r][col] = player;
                return true;
            }
        }
        return false;
    }

    static boolean checkWin(char player) {
        // Horizontal
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c <= COLS - 4; c++) {
                if (board[r][c] == player &&
                    board[r][c + 1] == player &&
                    board[r][c + 2] == player &&
                    board[r][c + 3] == player)
                    return true;
            }
        }

        // Vertical
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == player &&
                    board[r + 1][c] == player &&
                    board[r + 2][c] == player &&
                    board[r + 3][c] == player)
                    return true;
            }
        }

        // Diagonal (\)
        for (int r = 0; r <= ROWS - 4; r++) {
            for (int c = 0; c <= COLS - 4; c++) {
                if (board[r][c] == player &&
                    board[r + 1][c + 1] == player &&
                    board[r + 2][c + 2] == player &&
                    board[r + 3][c + 3] == player)
                    return true;
            }
        }

        // Diagonal (/)
        for (int r = 3; r < ROWS; r++) {
            for (int c = 0; c <= COLS - 4; c++) {
                if (board[r][c] == player &&
                    board[r - 1][c + 1] == player &&
                    board[r - 2][c + 2] == player &&
                    board[r - 3][c + 3] == player)
                    return true;
            }
        }

        return false;
    }

    static boolean isBoardFull() {
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == '.') {
                return false;
            }
        }
        return true;
    }
}
