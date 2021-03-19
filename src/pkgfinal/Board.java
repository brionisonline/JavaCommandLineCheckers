package pkgfinal;

public class Board {

    //6. multi dimensional array requirement
    public Square[][] board = new Square[8][8];

    void InitializeGameBoard() {
        int x = 0;
        int location;
        //2. enhanced for loop requirement
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
    }

    void PrintBoard() {

        System.out.print("  ");
        //2. for loop requirement
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        int x = 0;
        for (Square[] row : board) {
            System.out.print(x + " ");
            x++;
            int y = 0;
            for (Square col : row) {
                y++;
                System.out.print(col.getPopulation() + " ");
            }
            System.out.println();
        }
    }
}
