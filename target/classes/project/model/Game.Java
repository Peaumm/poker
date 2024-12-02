package project.model;

import java.util.List;

public class Game {

    public Player determineWinner(List<Player> players) {
        Rules rules = new Rules();
        Player winner = null;
        int highestScore = 0;

        for (Player player : players) {
            int score = rules.evaluateHand(player.getHand());
            if (score > highestScore) {
                highestScore = score;
                winner = player;
            }
        }

        return winner;
    }
}
