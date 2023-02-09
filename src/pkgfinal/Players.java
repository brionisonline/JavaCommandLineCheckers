package pkgfinal;

import java.util.Random;
import java.util.Scanner;

public class Players {
    private static final Scanner input = new Scanner(System.in);

    static void playerMove(Board board) {
        int count = countPlayerPieces(board);

        if (count == 0) {
            System.out.println("CPU Wins. You lose. Loser. The CPU was pretty stupid too. How did you accomplish that?");
            Main.play();
            return;
        }

        Main.playerTurn = true;
        System.out.println("Make your move.");
        int[] move = readPlayerMove(board);

        if (!Moves.isLegal(move[0], move[1], move[2], move[3], board, Main.playerTurn)) {
            System.out.println("Illegal move, try again.");
            playerMove(board);
            return;
        }

        Square temp = board.board[move[0]][move[1]];
        board.board[move[0]][move[1]] = board.board[move[2]][move[3]];
        board.board[move[2]][move[3]] = temp;
        System.out.println(move[0] + "" + move[1] + " " + move[2] + "" + move[3]);

        if (move[2] == 0) {
            board.board[move[2]][move[3]].setPopulation('O');
            board.board[move[2]][move[3]].setIsKing(true);
        }
        board.printBoard();
        Main.playerTurn = false;
        Players.cpuMove(board);
    }

    private static int countPlayerPieces(Board board) {
        int count = 0;
        for (Square[] board1 : board.board) {
            for (Square square : board1) {
                if (square.getIsPopulated() && square.getIsPlayerPopulated()) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] readPlayerMove(Board board) {
        int[] move = new int[4];
        String inputLine = input.nextLine();
        try {
            move[0] = inputLine.charAt(0) - '0';
            move[1] = inputLine.charAt(1) - '0';
            move[2] = inputLine.charAt(3) - '0';
            move[3] = inputLine.charAt(4) - '0';
        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println("Maybe put a space in between the two locations, and remember, only numbers.");
            playerMove(board);
        }
        return move;
    }

    static Random random = new Random();

    static void cpuMove(Board board) {
        int count = 0;
        for (Square[] board1 : board.board) {
            for (Square square : board1) {
                if (square.getIsPopulated() && !square.getIsPlayerPopulated()) {
                    count++;
                }
            }
        }
        if (count != 0) {
            int a, b, x, y;
            do {
                a = random.nextInt(8);
                b = random.nextInt(8);
                x = random.nextInt(8);
                y = random.nextInt(8);
            } while (!Moves.isLegal(a, b, x, y, board, false));

            Square temp = board.board[a][b];
            board.board[a][b] = board.board[x][y];
            board.board[x][y] = temp;
            System.out.println(a + "" + b + " " + x + "" + y);
            if (x == 7) {
                board.board[x][y].setPopulation('X');
                board.board[x][y].setIsKing(true);
            }
            board.printBoard();

            Players.playerMove(board);
        } else {
            System.out.println("CPU loses. You win.");
            Main.play();
        }
    }
}
