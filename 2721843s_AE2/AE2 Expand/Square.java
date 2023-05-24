public class Square {
    private int ColPosition;
    private int RowPosition;
    private boolean HaveAShip;
    private Battleship ReferenceBattleship;
    private boolean FiredAShot;

    // set Square's attrbute
    public Square(int RowPosition, int ColPosition) {
        this.ColPosition = ColPosition;
        this.RowPosition = RowPosition;
        HaveAShip = false;
        ReferenceBattleship = null;
        FiredAShot = false;
    }

    // setter and getter
    public void setColPosition(int ColPosition) {
        this.ColPosition = ColPosition;
    }

    public void setRowPosition(int RowPosition) {
        this.RowPosition = RowPosition;
    }

    public void setHaveAShip(boolean HaveAShip) {
        this.HaveAShip = HaveAShip;
    }

    public void setReferenceBattleship(Battleship ReferenceBattleship) {
        this.ReferenceBattleship = ReferenceBattleship;
    }

    public void setFiredAShot(boolean FiredAShot) {
        this.FiredAShot = FiredAShot;
    }

    public int getColPosition() {
        return ColPosition;
    }

    public int getRowPosition() {
        return RowPosition;
    }

    public boolean getHaveAShip() {
        return HaveAShip;
    }

    public Battleship getReferenceBattleship() {
        return ReferenceBattleship;
    }

    public boolean getFiredAShot() {
        return FiredAShot;
    }

    // print the Square if the attribute is changed
    // when we check our code, we just need to set if(FiredAShot == false &&
    // HaveAShip == true){s = "+"} to show up all the battleship
    public String toString() {
        String s = String.format("%3s", "-");
        if (FiredAShot == true && HaveAShip == true) {
            s = String.format("%3s", "x");
        } else if (FiredAShot == true && HaveAShip == false) {
            s = String.format("%3s", "o");
        }
        return s;

    }
}
