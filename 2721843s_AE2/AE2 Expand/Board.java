
import java.util.Random;

public class Board {
    private int row = 10;
    private int column = 10;
    private int count = 5;
    private Square[][] Array;
    private Battleship[] battleship;

    // set the attribute
    public Board(int row, int column) {
        this.column = column;
        this.row = row;
        this.Array = new Square[row][column];
        this.battleship = new Battleship[count];
        PopulateBoard();
        GeneratingBattleships();
    }

    // setter and getter
    public void setrow(int row) {
        this.row = row;
    }

    public void setcolum(int column) {
        this.column = column;
    }

    public int getcolumn() {
        return column;
    }

    public int getrow() {
        return row;
    }

    public void setSquare(Square[][] Array) {
        this.Array = Array;
    }

    public Square[][] getSquare() {
        return Array;
    }

    public void setBattleship(Battleship[] battleship) {
        this.battleship = battleship;
    }

    public Battleship getbattleship(int i) {
        return battleship[i];
    }

    // the method to fill the board with square
    public void PopulateBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Square S = new Square(i, j);
                Array[i][j] = S;
            }
        }
    }

    // print the board
    public String toString() {
        String s = "";
        for (int k = 0; k < row; k++) {
            for (int l = 0; l < column; l++) {
                s += Array[k][l].toString();
            }
            s += "\n";
        }
        return s;
    }

    // method to generate the bettleship
    public void GeneratingBattleships() {
        // generate the samll ship, we just need to make sure the ship won't be overlap
        Random r = new Random();
        int SmallShip = 0;
        int MediumShips = 0;
        int Largeships = 0;
        while (SmallShip < SmallBattleship.getNumOfSmall()) {
            int shipRow = r.nextInt(row);
            int shipCol = r.nextInt(column);
            if (Array[shipRow][shipCol].getHaveAShip() == false) {
                SmallBattleship smallbattleship = new SmallBattleship();
                SmallShip++;
                Array[shipRow][shipCol].setReferenceBattleship(smallbattleship);
                Array[shipRow][shipCol].setHaveAShip(true);
            }
        }
        // generate the medium ship
        // my method to generate the battleship is to judge the direction first
        while (MediumShips < MediumBattleship.getNumOfMedium()) {
            Boolean wetherHorizontal = r.nextBoolean();
            if (wetherHorizontal == true) {
                // if the direction is horizontal, the scope should be in (10,9) to make sure
                // the battleship won't be out of the board
                int shipRow = r.nextInt(row);
                int shipCol = r.nextInt(column - 1);
                // judge there is any battleship have been set
                if (Array[shipRow][shipCol].getHaveAShip() == false
                        && Array[shipRow][shipCol + 1].getHaveAShip() == false) {
                    // set the battleship and go on setting next one
                    MediumBattleship mediumbattleship = new MediumBattleship();
                    MediumShips++;
                    Array[shipRow][shipCol].setReferenceBattleship(mediumbattleship);
                    Array[shipRow][shipCol + 1].setReferenceBattleship(mediumbattleship);
                    Array[shipRow][shipCol].setHaveAShip(true);
                    Array[shipRow][shipCol + 1].setHaveAShip(true);
                }
            } else {
                // if the direction is vertical, the scope should be in (9,10) to make sure the
                // battleship won't be out of the board
                int shipRow = r.nextInt(row - 1);
                int shipCol = r.nextInt(column);
                // then same as the horizontal
                if (Array[shipRow][shipCol].getHaveAShip() == false
                        && Array[shipRow + 1][shipCol].getHaveAShip() == false) {
                    MediumBattleship mediumbattleship = new MediumBattleship();
                    MediumShips++;
                    Array[shipRow][shipCol].setReferenceBattleship(mediumbattleship);
                    Array[shipRow + 1][shipCol].setReferenceBattleship(mediumbattleship);
                    Array[shipRow][shipCol].setHaveAShip(true);
                    Array[shipRow + 1][shipCol].setHaveAShip(true);

                }

            }
        }
        // generate the large ship, just same as medium ship. the only different is the
        // scope of (x,y) is (7,10) and (10,7)
        while (Largeships < LargeBattleship.getNumOfLarge()) {
            Boolean wetherHorizontal = r.nextBoolean();
            if (wetherHorizontal == true) {

                int shipRow = r.nextInt(row);
                int shipCol = r.nextInt(column - 2);
                if (Array[shipRow][shipCol].getHaveAShip() == false
                        && Array[shipRow][shipCol + 1].getHaveAShip() == false
                        && Array[shipRow][shipCol + 2].getHaveAShip() == false) {
                    LargeBattleship largebattleship = new LargeBattleship();
                    Largeships++;
                    Array[shipRow][shipCol].setReferenceBattleship(largebattleship);
                    Array[shipRow][shipCol + 1].setReferenceBattleship(largebattleship);
                    Array[shipRow][shipCol + 2].setReferenceBattleship(largebattleship);
                    Array[shipRow][shipCol].setHaveAShip(true);
                    Array[shipRow][shipCol + 1].setHaveAShip(true);
                    Array[shipRow][shipCol + 2].setHaveAShip(true);
                }

            } else {

                int shipRow = r.nextInt(row - 2);
                int shipCol = r.nextInt(column);
                if (Array[shipRow][shipCol].getHaveAShip() == false && Array[shipRow + 1][shipCol].getHaveAShip()
                        && Array[shipRow + 2][shipCol].getHaveAShip() == false) {
                    LargeBattleship largebattleship = new LargeBattleship();
                    Largeships++;
                    Array[shipRow][shipCol].setReferenceBattleship(largebattleship);
                    Array[shipRow + 1][shipCol].setReferenceBattleship(largebattleship);
                    Array[shipRow + 2][shipCol].setReferenceBattleship(largebattleship);
                    Array[shipRow][shipCol].setHaveAShip(true);
                    Array[shipRow + 1][shipCol].setHaveAShip(true);
                    Array[shipRow + 2][shipCol].setHaveAShip(true);

                }

            }
        }
    }
}
