package pkgfinal;

import java.util.Scanner;
import java.util.Random;

public class Moves {

    Random random = new Random();
    Scanner input = new Scanner(System.in);

    static boolean pawnMove(int a, int b, int x, int y, Board board, boolean isPlayerTurn) {
        if (!board.board[x][y].getIsPopulated()) {
            int direction = isPlayerTurn ? -1 : 1;
            if (x == a + direction && (y == b + 1 || y == b - 1)) {
                return true;
            } else {
                return jump(a, b, x, y, board, isPlayerTurn);
            }
        } else {
            return false;
        }
    }

    static boolean kingMove(int a, int b, int x, int y, Board board, boolean isPlayerTurn) {
        if (pawnMove(a, b, x, y, board, isPlayerTurn)) {
            return true;
        } else {
            return kingJump(a, b, x, y, board, isPlayerTurn);
        }
    }

    static boolean jump(int a, int b, int x, int y, Board board, boolean isPlayerTurn) {
        int direction = isPlayerTurn ? -1 : 1;
        if (x == a + 2 * direction && (y == b + 2 || y == b - 2)) {
            int jumpRow = a + direction;
            int jumpCol = y > b ? b + 1 : b - 1;
            if (board.board[jumpRow][jumpCol].getIsPopulated() && board.board[jumpRow][jumpCol].getIsPlayerPopulated() != isPlayerTurn) {
                board.board[jumpRow][jumpCol].setIsKing(false);
                board.board[jumpRow][jumpCol].setIsPopulated(false);
                board.board[jumpRow][jumpCol].setIsPlayerPopulated(false);
                board.board[jumpRow][jumpCol].setPopulation(' ');
                return true;
            }
        }
        return false;
    }

    static boolean kingJump(int a, int b, int x, int y, Board board, boolean isPlayerTurn) {
        if (jump(a, b, x, y, board, isPlayerTurn)) {
            return true;
        } else {
            int direction = isPlayerTurn ? -1 : 1;
            if (x == a + 2 * direction && (y == b + 2 || y == b - 2)) {
                int jumpRow = a + direction;
                int jumpCol = y > b ? b + 1 : b - 1;
                if (board.board[jumpRow][jumpCol].getIsPopulated() && board.board[jumpRow][jumpCol].getIsPlayerPopulated() != isPlayerTurn) {
                    board.board[jumpRow][jumpCol].setIsKing(false);
                    board.board[jumpRow][jumpCol].setIsPopulated(false);
                    board.board[jumpRow][jumpCol].setIsPlayerPopulated(false);
                    board.board[jumpRow][jumpCol].setPopulation(' ');
                    return true;
                }
            }
            return false;
        }
    }

    static boolean isLegal(int a, int b, int x, int y, Board board, boolean isPlayerTurn) {
        if (board.board[a][b].getIsPopulated() && board.board[a][b].getIsPlayerPopulated() == isPlayerTurn) {
            if (board.board[a][b].getIsKing()) {
                return kingMove(a, b, x, y, board, isPlayerTurn);
            } else {
                return pawnMove(a, b, x, y, board, isPlayerTurn);
            }
        } else {
            return false;
        }
    }
}
