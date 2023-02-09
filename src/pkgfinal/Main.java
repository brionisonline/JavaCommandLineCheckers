package pkgfinal;
import java.util.Random;

public class Main {

    static Random random = new Random();
    static Board board = new Board();
    Moves moves = new Moves();
    static boolean playerTurn;

    static void play() {
        board.initializeGameBoard();
        board.printBoard();
        //7. if else statement requirement
        if (random.nextBoolean()) {
            Players.playerMove(board);
        } else {
            Players.cpuMove(board);
        }

    }

    public static void main(String[] args) {
       play();
    }

}
