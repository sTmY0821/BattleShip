public class SmallBattleship extends Battleship {
    // Inherit the battleship
    public SmallBattleship() {
        super();
    }

    private static int numOfSmall = 3;

    public static int getNumOfSmall() {
        return numOfSmall;
    }

    public static void setNumOfSmall(int numOfSmall) {
        SmallBattleship.numOfSmall = numOfSmall;
    }

}