package pkgfinal;

public class Square {
// 5. attribute minimum met

    private int Location;
    private boolean IsBlack;
    private boolean IsPopulated;
    private boolean IsPlayerPopulated;
    private boolean IsKing;
    public char Population;

    Square() {

    }

    Square(int location, boolean isBlack, boolean isPopulated, boolean isPlayerPopulated, boolean isKing) {
        Location = location;
        IsBlack = isBlack;
        IsPopulated = isPopulated;
        IsPlayerPopulated = isPlayerPopulated;
        IsKing = isKing;
        if (IsPopulated) {
            if (IsPlayerPopulated) {
                if (IsKing) {
                    Population = 'O';
                } else {
                    Population = 'o';
                }
            } else {
                if (IsKing) {
                    Population = 'X';
                } else {
                    Population = 'x';
                }
            }
        } else {
            Population = ' ';
        }
    }

    public boolean getIsKing() {
        return IsKing;
    }

    public void setIsKing(boolean IsKing) {
        this.IsKing = IsKing;
    }

    void setLocation(int location) {
        Location = location;
    }

    void setIsBlack(boolean isBlack) {
        IsBlack = isBlack;
    }

    void setIsPopulated(boolean isPopulated) {
        IsPopulated = isPopulated;
    }

    void setIsPlayerPopulated(boolean isPlayerPopulated) {
        IsPlayerPopulated = isPlayerPopulated;
    }

    void setPopulation(char population) {
        Population = population;
    }

    int getLocation() {
        return Location;
    }

    boolean getIsBlack() {
        return IsBlack;
    }

    boolean getIsPopulated() {
        return IsPopulated;
    }

    boolean getIsPlayerPopulated() {
        return IsPlayerPopulated;
    }

    char getPopulation() {
        return Population;
    }

}
