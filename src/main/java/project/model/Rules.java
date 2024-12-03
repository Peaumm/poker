package project.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Rules {

    public int evaluateHand(List<Card> hand) {
        Map<String, Integer> rankCounts = new HashMap<>();
        Map<String, Integer> colorCounts = new HashMap<>();
        
        for (Card card : hand) {
            rankCounts.put(card.getRank(), rankCounts.getOrDefault(card.getRank(), 0) + 1);
            colorCounts.put(card.getColor(), colorCounts.getOrDefault(card.getColor(), 0) + 1);
        }

        if (isRoyalFlush(rankCounts, colorCounts)) return 10;
        if (isStraightFlush(rankCounts, colorCounts)) return 9;
        if (isFourOfAKind(rankCounts)) return 8;
        if (isFullHouse(rankCounts)) return 7;
        if (isFlush(colorCounts)) return 6;
        if (isStraight(rankCounts)) return 5;
        if (isThreeOfAKind(rankCounts)) return 4;
        if (isTwoPair(rankCounts)) return 3;
        if (isPair(rankCounts)) return 2;

        return 1; 
    }

    private boolean isRoyalFlush(Map<String, Integer> rankCounts, Map<String, Integer> colorCounts) {
        return isFlush(colorCounts) && hasRanks(rankCounts, "10", "J", "Q", "K", "A");
    }

    private boolean isStraightFlush(Map<String, Integer> rankCounts, Map<String, Integer> colorCounts) {
        return isFlush(colorCounts) && isStraight(rankCounts);
    }

    private boolean isFourOfAKind(Map<String, Integer> rankCounts) {
        return rankCounts.containsValue(4);
    }

    private boolean isFullHouse(Map<String, Integer> rankCounts) {
        return rankCounts.containsValue(3) && rankCounts.containsValue(2);
    }

    private boolean isFlush(Map<String, Integer> colorCounts) {
        return colorCounts.containsValue(5);
    }

    private boolean isStraight(Map<String, Integer> rankCounts) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int consecutive = 0;
        
        for (String rank : ranks) {
            if (rankCounts.containsKey(rank)) {
                consecutive++;
                if (consecutive == 5) return true;
            } else {
                consecutive = 0;
            }
        }
        return false;
    }

    private boolean isThreeOfAKind(Map<String, Integer> rankCounts) {
        return rankCounts.containsValue(3);
    }

    private boolean isTwoPair(Map<String, Integer> rankCounts) {
        int pairCount = 0;
        for (int count : rankCounts.values()) {
            if (count == 2) pairCount++;
        }
        return pairCount == 2;
    }

    private boolean isPair(Map<String, Integer> rankCounts) {
        return rankCounts.containsValue(2);
    }

    private boolean hasRanks(Map<String, Integer> rankCounts, String... ranks) {
        for (String rank : ranks) {
            if (!rankCounts.containsKey(rank)) return false;
        }
        return true;
    }
}
