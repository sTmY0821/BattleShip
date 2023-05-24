import java.util.Random;

public class Board {
    private int row = 10;
    private int column = 10;
    private Square[][] Array;

    // set the attribute
    public Board(int row, int column) {
        this.column = column;
        this.row = row;
        this.Array = new Square[row][column];
        // use the method to fill the board with square and battleship
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
        Random r = new Random();
        // we need to generate 5 ship
        int ships = 0;
        while (ships < 5) {
            // my method to generate the battleship is to judge the direction first
            Boolean wetherHorizontal = r.nextBoolean();
            if (wetherHorizontal == true) {
                // if the direction is horizontal, the scope should be in (10,9) to make sure
                // the battleship won't be out of the board
                int shipRow = r.nextInt(row);
                int shipCol = r.nextInt(column - 1);
                // judge there is any battleship have been set
                if (Array[shipRow][shipCol].getHaveAShip() == false
                        && Array[shipRow][shipCol + 1].getHaveAShip() == false) {
                    Battleship battleship = new Battleship();
                    // set the battleship and go on setting next one
                    ships++;
                    Array[shipRow][shipCol].setReferenceBattleship(battleship);
                    Array[shipRow][shipCol + 1].setReferenceBattleship(battleship);
                    Array[shipRow][shipCol].setHaveAShip(true);
                    Array[shipRow][shipCol + 1].setHaveAShip(true);
                }
            } else {
                // if the direction is vertical, the scope should be in (9,10) to make sure the
                // battleship won't be out of the board
                int shipRow = r.nextInt(row - 1);
                int shipCol = r.nextInt(column);
                // just same as above code
                if (Array[shipRow][shipCol].getHaveAShip() == false
                        && Array[shipRow + 1][shipCol].getHaveAShip() == false) {
                    Battleship battleship = new Battleship();
                    ships++;
                    Array[shipRow][shipCol].setReferenceBattleship(battleship);
                    Array[shipRow + 1][shipCol].setReferenceBattleship(battleship);
                    Array[shipRow][shipCol].setHaveAShip(true);
                    Array[shipRow + 1][shipCol].setHaveAShip(true);

                }

            }
        }
    }
}
