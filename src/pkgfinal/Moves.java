package pkgfinal;

import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.util.Random;

public class Moves {

    Random random = new Random();
    Scanner input = new Scanner(System.in);
    //8. static variable requirement
    static boolean playerTurn = false;
//playermove method which first checks each piece on the board to see if there are
    //any available moves before offering the turn to the player
    //then prompts the player for a move, splits that move into variables and 
    //sends the move to the boolean "isLegal" method before executing the move

    void PlayerMove(Board board) {
        int count = 0;
        for (Square[] board1 : board.board) {
            for (int y = 0; y < board.board.length; y++) {
                if (board1[y].getIsPopulated() && board1[y].getIsPlayerPopulated()) {
                    count++;
                }
            }
        }
        if (count != 0) {
            playerTurn = true;
            System.out.println("Make your move.");
            int a, b, x, y;
            a = b = x = y = 0;
            // 11. Exception handling requirement
            try {

                String move = input.nextLine();

                a = parseInt(move.substring(0, 1));
                b = parseInt(move.substring(1, 2));
                x = parseInt(move.substring(3, 4));
                y = parseInt(move.substring(4, 5));
            } catch (NumberFormatException ex) {
                System.out.println("Maybe put a space in between the two locations, and remember, only numbers.");
            } finally {
                board.PrintBoard();
            }
            if (IsLegal(a, b, x, y, board, playerTurn)) {
                Square temp = board.board[a][b];
                board.board[a][b] = board.board[x][y];
                board.board[x][y] = temp;
                System.out.println(a + "" + b + " " + x + "" + y);
                if (x == 0) {
                    board.board[x][y].setPopulation('O');
                    board.board[x][y].setIsKing(true);
                }
                board.PrintBoard();
            } else {
                System.out.println("Illegal move, try again.");
                PlayerMove(board);
            }
            playerTurn = false;

            CPUMove(board);
        } else {
            System.out.println("CPU Wins. You lose. Loser. The CPU was pretty stupid too. How did you accomplish that?");
            new Game().Play();
        }
    }
//cpumove does the same as the playermove class, but does a few more checks first,
    //since it deals with random number generation

    void CPUMove(Board board) {
        int count = 0;
        for (Square[] board1 : board.board) {
            for (int y = 0; y < board.board.length; y++) {
                if (board1[y].getIsPopulated() && !board1[y].getIsPlayerPopulated()) {
                    count++;
                }
            }
        }
        if (count != 0) {
            int a;
            int b;
            int x;
            int y;
            //2. Do while requirement
            do {
                a = random.nextInt(8);
                b = random.nextInt(8);
                x = random.nextInt(8);
                y = random.nextInt(8);
            } while ((Math.abs(a - x) != 2 && Math.abs(a - x) != 1) || (Math.abs(b - y) != 2 && Math.abs(b - y) != 1));
            try {
                if (IsLegal(a, b, x, y, board, false)) {
                    Square temp = board.board[a][b];
                    board.board[a][b] = board.board[x][y];
                    board.board[x][y] = temp;
                    System.out.println(a + "" + b + " " + x + "" + y);
                    if (x == 7) {
                        board.board[x][y].setPopulation('X');
                        board.board[x][y].setIsKing(true);
                    }
                    board.PrintBoard();
                } else {
                    CPUMove(board);
                }
            } catch (StackOverflowError ex) {

            } finally {
                board.PrintBoard();
            }

            PlayerMove(board);
        } else {
            System.out.println("CPU loses. You win.");
            new Game().Play();
        }
    }

    boolean PawnMove(int a, int b, int x, int y, Board board, boolean playerTurn) {
        if (playerTurn) {
            return MoveUp(a, b, x, y, board, playerTurn);
        } else {
            return MoveDown(a, b, x, y, board, playerTurn);
        }
    }

    boolean MoveUp(int a, int b, int x, int y, Board board, boolean playerTurn) {
        if (!board.board[x][y].getIsPopulated()) {
            if ((x == a - 1 && y == b + 1)
                    || (x == a - 1 && y == b - 1)) {
                return true;
            } else {
                return JumpUp(a, b, x, y, board, playerTurn);
            }
        } else {
            return false;
        }
    }

    boolean MoveDown(int a, int b, int x, int y, Board board, boolean playerTurn) {
        if (!board.board[x][y].getIsPopulated()) {
            if ((x == a + 1 && y == b - 1)
                    || (x == a + 1 && y == b + 1)) {
                return true;
            } else {
                return JumpDown(a, b, x, y, board, playerTurn);
            }
        } else {
            return false;
        }
    }

    boolean KingMove(int a, int b, int x, int y, Board board, boolean playerTurn) {
        if (MoveUp(a, b, x, y, board, playerTurn) || MoveDown(a, b, x, y, board, playerTurn)) {
            return true;
        } else {
            return KingJump(a, b, x, y, board, playerTurn);
        }
    }

    boolean JumpUp(int a, int b, int x, int y, Board board, boolean playerTurn) {
        if (!board.board[x][y].getIsPopulated()) {
            if (x == a - 2 && y == b + 2) {
                if (board.board[x + 1][y - 1].getIsPopulated()) {
                    if (playerTurn) {
                        if (!board.board[x + 1][y - 1].getIsPlayerPopulated()) {
                            board.board[x + 1][y - 1].setIsKing(false);
                            board.board[x + 1][y - 1].setIsPopulated(false);
                            board.board[x + 1][y - 1].setIsPlayerPopulated(false);
                            board.board[x + 1][y - 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (board.board[x + 1][y - 1].getIsPlayerPopulated()) {
                            board.board[x + 1][y - 1].setIsKing(false);
                            board.board[x + 1][y - 1].setIsPopulated(false);
                            board.board[x + 1][y - 1].setIsPlayerPopulated(false);
                            board.board[x + 1][y - 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            } else if (x == a - 2 && y == b - 2) {
                if (board.board[x + 1][y + 1].getIsPopulated()) {
                    if (playerTurn) {
                        if (!board.board[x + 1][y + 1].getIsPlayerPopulated()) {
                            board.board[x + 1][y + 1].setIsKing(false);
                            board.board[x + 1][y + 1].setIsPopulated(false);
                            board.board[x + 1][y + 1].setIsPlayerPopulated(false);
                            board.board[x + 1][y + 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (board.board[x + 1][y + 1].getIsPlayerPopulated()) {
                            board.board[x + 1][y + 1].setIsKing(false);
                            board.board[x + 1][y + 1].setIsPopulated(false);
                            board.board[x + 1][y + 1].setIsPlayerPopulated(false);
                            board.board[x + 1][y + 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    boolean JumpDown(int a, int b, int x, int y, Board board, boolean playerTurn) {
        if (!board.board[x][y].getIsPopulated()) {
            if (x == a + 2 && y == b - 2) {
                if (board.board[x - 1][y + 1].getIsPopulated()) {
                    if (playerTurn) {
                        if (!board.board[x - 1][y + 1].getIsPlayerPopulated()) {
                            board.board[x - 1][y + 1].setIsKing(false);
                            board.board[x - 1][y + 1].setIsPopulated(false);
                            board.board[x - 1][y + 1].setIsPlayerPopulated(false);
                            board.board[x - 1][y + 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (board.board[x - 1][y + 1].getIsPlayerPopulated()) {
                            board.board[x - 1][y + 1].setIsKing(false);
                            board.board[x - 1][y + 1].setIsPopulated(false);
                            board.board[x - 1][y + 1].setIsPlayerPopulated(false);
                            board.board[x - 1][y + 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            } else if (x == a + 2 && y == b + 2) {
                if (board.board[x - 1][y - 1].getIsPopulated()) {
                    if (playerTurn) {
                        if (!board.board[x - 1][y - 1].getIsPlayerPopulated()) {
                            board.board[x - 1][y - 1].setIsKing(false);
                            board.board[x - 1][y - 1].setIsPopulated(false);
                            board.board[x - 1][y - 1].setIsPlayerPopulated(false);
                            board.board[x - 1][y - 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        if (board.board[x - 1][y - 1].getIsPlayerPopulated()) {
                            board.board[x - 1][y - 1].setIsKing(false);
                            board.board[x - 1][y - 1].setIsPopulated(false);
                            board.board[x - 1][y - 1].setIsPlayerPopulated(false);
                            board.board[x - 1][y - 1].setPopulation(' ');
                            return true;
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    boolean KingJump(int a, int b, int x, int y, Board board, boolean playerTurn) {
        return JumpUp(a, b, x, y, board, playerTurn) || JumpUp(a, b, x, y, board, playerTurn);
    }

    boolean IsLegal(int a, int b, int x, int y, Board board, boolean playerTurn) {

        if (playerTurn) {
            if (board.board[a][b].getPopulation() == 'o' || board.board[a][b].getPopulation() == 'O') {
                if (board.board[a][b].getIsKing()) {
                    return KingMove(a, b, x, y, board, playerTurn);
                } else {
                    return PawnMove(a, b, x, y, board, playerTurn);
                }
            } else {
                return false;
            }
        } else {
            if (board.board[a][b].getPopulation() == 'x' || board.board[a][b].getPopulation() == 'X') {

                if (board.board[a][b].getIsKing()) {
                    return KingMove(a, b, x, y, board, playerTurn);
                } else {
                    return PawnMove(a, b, x, y, board, playerTurn);
                }
            } else {
                return false;
            }
        }

    }

}
