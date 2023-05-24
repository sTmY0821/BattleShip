public class Battleship {
    private boolean WheatherSunk;
    private int RemainingHealth;
    private int SizeofShip;

    // set the attribute
    public Battleship() {
        WheatherSunk = false;
        RemainingHealth = 2;
        SizeofShip = 2;
    }

    // setter and getter
    public void setWheatherSunk(boolean WheatherSunk) {
        this.WheatherSunk = WheatherSunk;
    }

    public void setRemainingHealth(int RemainingHealth) {
        this.RemainingHealth = RemainingHealth;
    }

    public void setSizeofShip(int SizeifShip) {
        this.SizeofShip = SizeofShip;
    }

    public int getRemainingHealth() {
        return RemainingHealth;
    }

    public int getSizeofShip() {
        return SizeofShip;
    }

}
