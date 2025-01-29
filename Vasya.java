import java.util.*;

public class Vasya {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read team names and number of events
        String homeTeam = sc.next();
        String awayTeam = sc.next();
        int numEvents = sc.nextInt();

        // Card counts: [yellow, red]
        int[][] homeCards = new int[100][2];
        int[][] awayCards = new int[100][2];

        // Process each event
        for (int i = 0; i < numEvents; i++) {
            int time = sc.nextInt();
            String team = sc.next();
            int playerNumber = sc.nextInt();
            String cardType = sc.next();

            // Determine the team and update the card count
            if (team.equals("h")) {
                if (cardType.equals("r")) {
                    homeCards[playerNumber][1]++; // Red card
                } else if (cardType.equals("y")) {
                    homeCards[playerNumber][0]++; // Yellow card
                }

                // Check if the player should be sent off
                if (homeCards[playerNumber][0] == 2 || homeCards[playerNumber][1] == 1) {
                    System.out.println(homeTeam + " " + playerNumber + " " + time);
                    homeCards[playerNumber][0] = 0; // Reset card count to avoid duplicate output
                }
            } else if (team.equals("a")) {
                if (cardType.equals("r")) {
                    awayCards[playerNumber][1]++; // Red card
                } else if (cardType.equals("y")) {
                    awayCards[playerNumber][0]++; // Yellow card
                }

                // Check if the player should be sent off
                if (awayCards[playerNumber][0] == 2 || awayCards[playerNumber][1] == 1) {
                    System.out.println(awayTeam + " " + playerNumber + " " + time);
                    awayCards[playerNumber][0] = 0; // Reset card count to avoid duplicate output
                }
            }
        }

        sc.close();
    }
}
