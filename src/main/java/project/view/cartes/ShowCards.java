package project.view.cartes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShowCards extends JPanel {
    public int[][] tab = {
        {1,2,3,4,5,6,7,8},
        {9,10,11,12,13,14,15,16},
        {17,18,19,20,21,22,23,24},
        {25,26,27,28,29,30,31,32},
        {33,34,35,36,37,38,39,40},
        {41,42,43,44,45,46,47,48},
        {49,50,51,52,0,0,0,0},
    };

    public ShowCards () {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle("Poker");
        frame.setSize(1280, 720 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cartePanel = new JPanel();
        JPanel carteAdversPanel = new JPanel();
        JPanel tout = new JPanel();

        tout.setLayout(new BorderLayout());

        cartePanel.setLayout(new BoxLayout(cartePanel, BoxLayout.X_AXIS));
        carteAdversPanel.setLayout(new BoxLayout(carteAdversPanel, BoxLayout.X_AXIS));

        Dimension dimHauteur = new Dimension(Integer.MAX_VALUE, 300);
//        Dimension dimLargeur = new Dimension(100, Integer.MAX_VALUE);
        cartePanel.setPreferredSize(dimHauteur);
        carteAdversPanel.setPreferredSize(dimHauteur);

        List<Carte> listCartes = new ArrayList<>();

        for (int i = 0; listCartes.size() < 5; i++) {
            boolean exist = false;
            Carte carte = new Carte();

            if (tab[carte.getLigne()][carte.getColonne()] == 0) {
                exist = true;
            } else {
                positionCarte(carte.getLigne(), carte.getColonne(), tab);
            }

            if (!exist) {
                listCartes.add(carte);
            }
        }

        for (Carte carte : listCartes) {
            cartePanel.add(carte);
        }

        for (int i = 0; i < 5; i++) {
            carteAdversPanel.add(new CarteAdverse());
        }

        displayBoard(tab);

        tout.add(cartePanel, BorderLayout.SOUTH);
        tout.add(carteAdversPanel, BorderLayout.NORTH);

        frame.add(tout);
        frame.setVisible(true);

    }

    public static void displayBoard( int [][] tab ) {
        for (int[] ints : tab) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    public void positionCarte(int ligne, int colonne, int[][] tab) {
        tab[ligne][colonne] = 0;
    }
}
