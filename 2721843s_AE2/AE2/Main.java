import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.println("Please input Player1's name!");
        String Player1Name = t.nextLine();
        System.out.println("Please input Player2's name!");
        String Player2Name = t.nextLine();
        Player Player1 = new Player(Player1Name, 0);
        Player Player2 = new Player(Player2Name, 0);
        // start loop to play the game
        while (true) {
            // Print the name, score, and the board
            System.out.println(Player1.toString());
            System.out.println(Player2.toString());
            Player1.takeTurn();
            Player2.takeTurn();
            // announce who is winner, and the method is by checking who reach 5 score first
            if (Player1.getScore() == 5 && Player2.getScore() != 5) {
                System.out.println(Player1.getName() + " is winner");
                break;
            } else if (Player1.getScore() != 5 && Player2.getScore() == 5) {
                System.out.println(Player2.getName() + " is winner");
                break;
            } else if (Player1.getScore() == 5 && Player2.getScore() == 5) {
                System.out.println("Draw!!!!");
                break;
            }
        }

    }
}
