package project.view.cartes;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import project.tool.Functions;
public class ShowCards extends JPanel {

    private int[][] tab = {
        {1,2,3,4,5,6,7,8},
        {9,10,11,12,13,14,15,16},
        {17,18,19,20,21,22,23,24},
        {25,26,27,28,29,30,31,32},
        {33,34,35,36,37,38,39,40},
        {41,42,43,44,45,46,47,48},
        {49,50,51,52,0,0,0,0},
    };

    private List<Carte> listCartes = new ArrayList<>();
    private JPanel cartePanel = new JPanel();

    public ShowCards() {
        JFrame frame = new JFrame();
        cartePanel.setLayout(new BoxLayout(cartePanel, BoxLayout.X_AXIS));
        
        for (int i = 0; listCartes.size() < 5; i++) {
            int ligne = Functions.alea(0, 6);
            int colonne = Functions.alea(0, 7);

            if (tab[ligne][colonne] != 0) {
                Carte carte = new Carte(ligne, colonne);
                listCartes.add(carte);
                tab[ligne][colonne] = 0;  
            }
        }

        JButton exchangeButton = new JButton("Échanger les cartes");
        exchangeButton.addActionListener(e -> exchangeCards());

        for (Carte carte : listCartes) {
            cartePanel.add(carte);
        }

        this.setLayout(new BorderLayout());
        this.add(cartePanel, BorderLayout.CENTER);
        this.add(exchangeButton, BorderLayout.SOUTH);

        frame.setTitle("Poker");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
    }

    public void exchangeCards() {
        List<Carte> cardsToExchange = new ArrayList<>();

        for (Carte carte : listCartes) {
            if (carte.isSelected()) {
                cardsToExchange.add(carte);
            }
        }

        if (cardsToExchange.size() > 0 && cardsToExchange.size() <= 4) {
            for (Carte carte : cardsToExchange) {
                listCartes.remove(carte);
                int ligne, colonne;
                do {
                    ligne = Functions.alea(0, 6);
                    colonne = Functions.alea(0, 7);
                } while (tab[ligne][colonne] == 0);
                Carte newCard = new Carte(ligne, colonne);
                listCartes.add(newCard);
                tab[ligne][colonne] = 0; 
            }

            cartePanel.removeAll();
            for (Carte carte : listCartes) {
                cartePanel.add(carte);
            }
            cartePanel.revalidate();
            cartePanel.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Vous devez sélectionner entre 1 et 4 cartes à échanger.");
        }
    }

    public static void displayBoard(int[][] tab) {
        for (int[] row : tab) {
            for (int card : row) {
                System.out.print(card + " ");
            }
            System.out.println();
        }
    }
}
