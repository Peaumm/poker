package project.model;

public class Card {
    private String rank; // valeur 
    private String color; // couleur 

    public Card(String rank, String color) {
        this.rank = rank;
        this.color = color;
    }

    public String getRank() {
        return rank;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return rank + " of " + color;
    }
}
