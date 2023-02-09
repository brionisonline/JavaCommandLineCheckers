package pkgfinal;

public class Board {

    private static final int ROWS = 8;
    private static final int COLUMNS = 8;
    private boolean isBoardCreated = false;
    
    public Square[][] board = new Square[ROWS][COLUMNS];
    
    void initializeGameBoard() {
        if (!isBoardCreated) {
            int x = 0;
            int location;

            for (Square[] row : board) {
                int y = 0;
                for (Square col : row) {
                    location = Integer.parseInt(String.valueOf(x) + Integer.toString(y));
                    switch (x) {
                        case 0:
                        case 2:
                            if (y == 0 || y == 2 || y == 4 || y == 6) {
                                board[x][y] = new Square(location, true, true, false, false);
                            } else {
                                board[x][y] = new Square(location, false, false, false, false);
                            }
                            break;
                        case 1:
                            if (y == 1 || y == 3 || y == 5 || y == 7) {
                                board[x][y] = new Square(location, true, true, false, false);
                            } else {
                                board[x][y] = new Square(location, false, false, false, false);
                            }
                            break;
                        case 3:
                        case 4:
                            if (y == 0 || y == 2 || y == 4 || y == 6) {
                                board[x][y] = new Square(location, true, false, false, false);
                            } else {
                                board[x][y] = new Square(location, false, false, false, false);
                            }
                            break;
                        case 5:
                        case 7:
                            if (y == 1 || y == 3 || y == 5 || y == 7) {
                                board[x][y] = new Square(location, true, true, true, false);
                            } else {
                                board[x][y] = new Square(location, false, false, false, false);
                            }
                            break;
                        case 6:
                            if (y == 0 || y == 2 || y == 4 || y == 6) {
                                board[x][y] = new Square(location, true, true, true, false);
                            } else {
                                board[x][y] = new Square(location, false, false, false, false);
                            }
                            break;
                        default:
                            break;
                    }
                    y++;
                }
                x++;
            }
            isBoardCreated = true;
        }
    }
    

    void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < COLUMNS; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int x = 0; x < ROWS; x++) {
            System.out.print(x + " ");
            for (int y = 0; y < COLUMNS; y++) {
                System.out.print(board[x][y].getPopulation() + " ");
            }
            System.out.println();
        }
    }   
    // void printBoard() {
    //     System.out.print("  ");
    //     for (int i = 97; i < 105; i++) {
    //         System.out.print((char)i + " ");
    //     }
    //     System.out.println();
    //     for (int x = 8; x > 0; x--) {
    //         System.out.print(x + " ");
    //         for (int y = 97; y < 105; y++) {
    //             System.out.print(board[x-1][y-97].getPopulation() + " ");
    //         }
    //         System.out.println();
    //     }
    // } 
    
    
}
