package project.model;

import java.util.List;
import java.util.ArrayList;

public class Player {

    private Integer id;
    private String name;
    private List<Integer> cards;
    private Integer money;
    private Integer betAmount;

    public Player() {
    }

    public Player(Integer id, String name, Integer cards, Integer money, Integer betAmount) {
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
        this.money = money;
        this.betAmount = 0;

    }

    public Player(String name, Integer cards, Integer money) {
        this.name = name;
        this.cards = new ArrayList<>();
        this.money = money;
    }

    public Player(Integer id, String name, Integer money) {
        this.id = id;
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public Player(String name, Integer carte) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public Integer getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Integer betAmount) {
        this.betAmount = betAmount;
    }

    public void setCards(List<Integer> cards) {
        this.cards = cards;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

}
