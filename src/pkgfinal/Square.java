package pkgfinal;
public class Square {
    private int location;
    private boolean isBlack;
    private boolean isPopulated;
    private boolean isPlayerPopulated;
    private boolean isKing;
    private char population;

    Square(int location, boolean isBlack, boolean isPopulated, boolean isPlayerPopulated, boolean isKing) {
        setLocation(location);
        setIsBlack(isBlack);
        setIsPopulated(isPopulated);
        setIsPlayerPopulated(isPlayerPopulated);
        setIsKing(isKing);
        if (isPopulated) {
            if (isPlayerPopulated) {
                if (isKing) {
                    population = 'O';
                } else {
                    population = 'o';
                }
            } else {
                if (isKing) {
                    population = 'X';
                } else {
                    population = 'x';
                }
            }
        } else {
            population = ' ';
        }
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(boolean isBlack) {
        this.isBlack = isBlack;
    }

    public boolean getIsPopulated() {
        return isPopulated;
    }

    public void setIsPopulated(boolean isPopulated) {
        this.isPopulated = isPopulated;
    }

    public boolean getIsPlayerPopulated() {
        return isPlayerPopulated;
    }

    public void setIsPlayerPopulated(boolean isPlayerPopulated) {
        this.isPlayerPopulated = isPlayerPopulated;
    }

    public boolean getIsKing() {
        return isKing;
    }

    public void setIsKing(boolean isKing) {
        this.isKing = isKing;
    }

    public char getPopulation() {
        return population;
    }

    public void setPopulation(char population) {
        this.population = population;
    }
}
