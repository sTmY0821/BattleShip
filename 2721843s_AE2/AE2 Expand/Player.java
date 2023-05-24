import java.util.Scanner;

public class Player {
    private String Name;
    private int Score;
    private Board Board;

    // set the attribute
    public Player(String Name, int Score) {
        this.Name = Name;
        this.Score = Score;
        this.Board = new Board(10, 10);
    }

    // setter and getter
    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public Board getBoard() {
        return Board;
    }

    public void setBoard(Board board) {
        Board = board;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String toString() {
        return Name + "'s score is " + Score + '\n' + Board.toString();
    }

    // method to play the game
    public boolean takeTurn() {
        Scanner number = new Scanner(System.in);
        System.out.println("please enter x and y");
        // Change the range to 1-10
        int x = number.nextInt() - 1;
        int y = number.nextInt() - 1;
        // in case input the position that have been shouted make the score
        if (Board.getSquare()[x][y].getFiredAShot() == false) {
            if (Board.getSquare()[x][y].getHaveAShip() == true) {
                Board.getSquare()[x][y].setFiredAShot(true);
                int h = Board.getSquare()[x][y].getReferenceBattleship().getRemainingHealth() - 1;
                Board.getSquare()[x][y].getReferenceBattleship().setRemainingHealth(h);
                if (Board.getSquare()[x][y].getReferenceBattleship().getRemainingHealth() == 0) {
                    Board.getSquare()[x][y].getReferenceBattleship().setWheatherSunk(true);
                    System.out.println("One ship is sunk!!");
                    Score++;
                }
                // set the battleship null
                Board.getSquare()[x][y].setReferenceBattleship(null);
            } else {
                Board.getSquare()[x][y].setFiredAShot(true);
                System.out.println("Sorry you miss");
            }
        }
        // check if there is any batthle ship in the board. if not game over
        for (int i = 0; i < Board.getrow(); i++) {
            for (int j = 0; j < Board.getcolumn(); j++) {
                if (Board.getSquare()[i][j].getReferenceBattleship() != null) {
                    return false;
                }
            }
        }
        return true;
    }

}
