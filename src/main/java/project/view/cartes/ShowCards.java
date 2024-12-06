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


    JFrame frame;
    JPanel cartePanel;
    JPanel carteAdversPanel;
    JPanel tout;
    JPanel revealPanel;

    public ShowCards () {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Poker");
        frame.setSize(1280, 720 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cartePanel = new JPanel();
        carteAdversPanel = new JPanel();
        tout = new JPanel();

        tout.setLayout(new BorderLayout());

        cartePanel.setLayout(new BoxLayout(cartePanel, BoxLayout.X_AXIS));
        carteAdversPanel.setLayout(new BoxLayout(carteAdversPanel, BoxLayout.X_AXIS));

        Dimension dimHauteur = new Dimension(Integer.MAX_VALUE, 300);
//        Dimension dimLargeur = new Dimension(100, Integer.MAX_VALUE);
        cartePanel.setPreferredSize(dimHauteur);
        carteAdversPanel.setPreferredSize(dimHauteur);

        List<Carte> listCartes = new ArrayList<>();


        for (int i = 0; listCartes.size() < 5; i++) {
            int ligne = Functions.alea(0, 6);
            int colonne = Functions.alea(0, 7);

            if (tab[carte.getLigne()][carte.getColonne()] == 0) {
                exist = true;
            } else {
                carte.setValeur(tab[carte.getLigne()][carte.getColonne()]);
                positionCarte(carte.getLigne(), carte.getColonne(), tab);
            }

            if (!exist) {
                listCartes.add(carte);
                tab[ligne][colonne] = 0;  
            }
        }

        JButton exchangeButton = new JButton("Échanger les cartes");
        exchangeButton.addActionListener(e -> exchangeCards());

        for (Carte carte : listCartes) {
            System.out.println(carte.getValeur());
            cartePanel.add(carte);
        }

        List<CarteAdverse> listCartesAdverse = new ArrayList<>();

        for (int i = 0; listCartesAdverse.size() < 5; i++) {
            boolean exist = false;
            CarteAdverse carteAdverse = new CarteAdverse();
            if (tab[carteAdverse.getLigne()][carteAdverse.getColonne()] == 0) {
                exist = true;
            } else {
                carteAdverse.setValeur(tab[carteAdverse.getLigne()][carteAdverse.getColonne()]);
                positionCarte(carteAdverse.getLigne(), carteAdverse.getColonne(), tab);
            }

            if (!exist) {
                listCartesAdverse.add(carteAdverse);
            }
        }

        for (CarteAdverse carteAdverse : listCartesAdverse) {
            System.out.println(carteAdverse.getValeur());
            carteAdversPanel.add(carteAdverse);
        }

//        JButton button = new JButton("OK");
//        button.addActionListener(e -> {
//            tout.remove(carteAdversPanel);
//            revealPanel = new JPanel();
//            revealPanel.setPreferredSize(dimHauteur);
//            revealPanel.setLayout(new BoxLayout(revealPanel, BoxLayout.X_AXIS));
//
//            for (CarteAdverse carteAdverse : listCartesAdverse) {
//                Carte newCarte = new Carte(carteAdverse.getValeur());
//                System.out.println(carteAdverse.getLigne() + " " + carteAdverse.getColonne());
//                revealPanel.add(newCarte);
//            }
//            tout.add(revealPanel, BorderLayout.NORTH);
//            frame.revalidate();
//        });

        displayBoard(tab);

        tout.add(cartePanel, BorderLayout.SOUTH);
        tout.add(carteAdversPanel, BorderLayout.NORTH);
//        tout.add(button, BorderLayout.CENTER);

        frame.add(tout);
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
