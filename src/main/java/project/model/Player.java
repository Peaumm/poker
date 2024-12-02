package project.model;

public class Player {

  private Integer id;
  private String name;
  private Integer cards;
  private Integer money;


  public Player(){};

  public Player(Integer id, String name, Integer cards, Integer money) {
    this.id = id;
    this.name = name;
    this.cards = cards;
    this.money = money;
  }

  public Player(String name, Integer cards, Integer money) {
    this.name = name;
    this.cards = cards;
    this.money = money;
  }

  public Player(Integer id, String name, Integer money) {
    this.id = id;
    this.name = name;
    this.cards = money;
  }

  public Player(String name, Integer carte) {
    this.name = name;
    this.cards = carte;
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

  public Integer getcards() {
    return cards;
  }
  
  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

}
