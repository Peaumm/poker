package project.view.Input;

import project.view.cartes.Carte;
import project.view.cartes.CarteAdverse;
import project.view.cartes.ShowCards;

import java.util.List;
import java.awt.*;
import javax.swing.*;

public class MiseInputPanel extends JPanel {
  private JButton btnMiser1, btnMiser3, btnMiser5, btnMiser10, btnMiser50, btnMiser100, btnTapis;
  private JLabel resultLabel;
  private int playerMoney = 0;
  JButton button;
  JPanel revealPanel;
  JButton newGameButton;


  public MiseInputPanel(int initialMoney, ShowCards exchange, List<Carte> list, JPanel tout, JPanel carteAdversPanel, List<CarteAdverse> listCartesAdverse) {
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
    add(resultLabel, BorderLayout.WEST);

    Dimension dimHauteur = new Dimension(Integer.MAX_VALUE, 300);

    newGameButton = new JButton("Nouveau Jeu ?");
    newGameButton.setPreferredSize(new Dimension(250, 60));
    newGameButton.addActionListener(e -> {
        boolean game = true;
        new ShowCards(playerMoney);
    });

    button = new JButton("Révéler les cartes adverses");
    button.setPreferredSize(new Dimension(250, 60));
    button.addActionListener(e -> {
      tout.remove(carteAdversPanel);
      revealPanel = new JPanel();
      revealPanel.setPreferredSize(dimHauteur);
      revealPanel.setLayout(new BoxLayout(revealPanel, BoxLayout.X_AXIS));

      for (CarteAdverse carteAdverse : listCartesAdverse) {
          Carte newCarte = new Carte(carteAdverse.getValeur());
          System.out.println(carteAdverse.getLigne() + " " + carteAdverse.getColonne());
          revealPanel.add(newCarte);
      }
      tout.add(revealPanel, BorderLayout.NORTH);
      buttonsPanel.removeAll();
      buttonsPanel.add(newGameButton);
      tout.revalidate();
    });

    addActionsMise(buttonsPanel, exchange, list, button);
  }

  private JButton createButton(String text) {
    JButton button = new JButton(text);
    button.setPreferredSize(new Dimension(90, 40));
    return button;
  }

  private void addActionsMise(JPanel buttonsPanel, ShowCards exchange, List<Carte> list, JButton button) {
    btnMiser1.addActionListener(e -> {
        miser(1);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
    btnMiser3.addActionListener(e -> {
        miser(3);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
    btnMiser5.addActionListener(e -> {
        miser(5);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
    btnMiser10.addActionListener(e -> {
        miser(10);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
    btnMiser50.addActionListener(e -> {
        miser(50);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
    btnMiser100.addActionListener(e -> {
        miser(100);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
    btnTapis.addActionListener(e -> {
        miser(playerMoney);
        buttonsPanel.removeAll();
        buttonsPanel.add(button, BorderLayout.EAST);
        exchange.exchangeCards(list);
        revalidate();
        repaint();
    });
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
