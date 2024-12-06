package project.view.Input;

import java.awt.*;
import javax.swing.*;

public class MiseInputPanel extends JPanel {
  private JButton btnMiser1, btnMiser3, btnMiser5, btnMiser10, btnMiser50, btnMiser100, btnTapis;
  private JLabel resultLabel;
  private int playerMoney = 0;

  public MiseInputPanel(int initialMoney) {
    this.playerMoney = initialMoney;

    // Layout principal du panneau
    setLayout(new BorderLayout());

    // Conteneur pour les boutons
    JPanel buttonsPanel = new JPanel(new GridLayout(0, 2, 5, 5));

    // Boutons avec texte réduit pour un design compact
    btnMiser1 = createButton("Mise 1");
    btnMiser3 = createButton("Mise 3");
    btnMiser5 = createButton("Mise 5");
    btnMiser10 = createButton("Mise 10");
    btnMiser50 = createButton("Mise 50");
    btnMiser100 = createButton("Mise 100");
    btnTapis = createButton("Tapis");

    // Ajouter les boutons au panneau
    buttonsPanel.add(btnMiser1);
    buttonsPanel.add(btnMiser3);
    buttonsPanel.add(btnMiser5);
    buttonsPanel.add(btnMiser10);
    buttonsPanel.add(btnMiser50);
    buttonsPanel.add(btnMiser100);
    buttonsPanel.add(btnTapis);

    // Ajouter le panneau des boutons à droite
    add(buttonsPanel, BorderLayout.EAST);

    // Label d'information en bas
    resultLabel = new JLabel("Somme disponible : " + playerMoney + " jetons", SwingConstants.CENTER);
    add(resultLabel, BorderLayout.SOUTH);

    addActionsMise();
  }

  private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(90, 40));
    return button;
  }

  private void addActionsMise() {
    btnMiser1.addActionListener(e -> miser(1));
    btnMiser3.addActionListener(e -> miser(3));
    btnMiser5.addActionListener(e -> miser(5));
    btnMiser10.addActionListener(e -> miser(10));
    btnMiser50.addActionListener(e -> miser(50));
    btnMiser100.addActionListener(e -> miser(100));
    btnTapis.addActionListener(e -> miser(playerMoney));
  }

  private void miser(int amount) {
    if (amount > playerMoney) {
      resultLabel.setText("Erreur : Vous ne pouvez pas miser plus que votre somme disponible !");
    } else {
      playerMoney -= amount;
      resultLabel.setText("Vous avez misé " + amount + " jetons. Somme restante : " + playerMoney + " jetons");
    }
  }
}
