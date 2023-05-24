public class LargeBattleship extends Battleship {
    // Inherit the battleship
    public LargeBattleship() {
        super();
        setSizeofShip(3);
        setRemainingHealth(3);
    }

    private static int numOfLarge = 1;

    public static int getNumOfLarge() {
        return numOfLarge;
    }

    public static void setNumOfLarge(int numOfLarge) {
        LargeBattleship.numOfLarge = numOfLarge;
    }

}
