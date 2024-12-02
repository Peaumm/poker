package project.model;

import java.util.List;
import java.util.ArrayList;

import java.util.List;

public class Dealer {

    private Integer id;
    private Integer money;
    private List<Integer> cards;
    private Integer betAmount;

    public Dealer() {
    }

    public Dealer(Integer id, Integer money, Integer cards, Integer betAmount) {
        this.id = id;
        this.money = money;
        this.cards = new ArrayList<>();
        this.betAmount = 0;
    }

    public Dealer(Integer money, Integer cards, Integer betAmount) {
      this.money = money;
      this.cards = new ArrayList<>();
      this.betAmount = betAmount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public List<Integer> getCards() {
        return cards;
    }

    public void setCards(List<Integer> cards) {
        this.cards = cards;
    }

    public Integer getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(Integer betAmount) {
        this.betAmount = betAmount;
    }
}
