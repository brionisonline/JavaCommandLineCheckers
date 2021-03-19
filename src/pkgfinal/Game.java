package pkgfinal;

import java.util.Random;

public class Game {

    Random random = new Random();
    Board board = new Board();
    Moves move = new Moves();

    void Play() {
        board.InitializeGameBoard();
        board.PrintBoard();
        //7. if else statement requirement
        if (random.nextBoolean()) {
            move.PlayerMove(board);
        } else {
            move.CPUMove(board);
        }

    }

}
