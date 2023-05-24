public class MediumBattleship extends Battleship {
    public static int numOfMedium = 2;

    // Inherit the battleship
    public MediumBattleship() {
        super();
    }

    public static int getNumOfMedium() {
        return numOfMedium;
    }

    public static void setNumOfMedium(int numOfMedium) {
        MediumBattleship.numOfMedium = numOfMedium;
    }

}
