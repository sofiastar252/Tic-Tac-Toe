import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        char currentPlayer = 'X';
        boolean isGameFinished = false;

        printBoard(board);

        while (!isGameFinished) {
            makeMove(board, currentPlayer);
            printBoard(board);

            if (isWinner(board, currentPlayer)) {
                System.out.println("Congrats! Player " + currentPlayer + " wins!");
                isGameFinished = true;
            } else if (isBoardFull(board)) {
                System.out.println("The game is a tie!");
                isGameFinished = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private static void printBoard(char[][] board) {
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

    private static void makeMove(char[][] board, char currentPlayer) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column, e.g., 1 2): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(board, row, col));

        board[row][col] = currentPlayer;
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    private static boolean isWinner(char[][] board, char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        // Check diagonals
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
