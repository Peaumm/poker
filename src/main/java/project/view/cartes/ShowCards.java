package project.view.cartes;

import project.view.Input.MiseInputPanel;
import project.view.Input.MoneyInputPanel;

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

    JFrame frame;
    JPanel cartePanel;
    JPanel carteAdversPanel;
    JPanel buttonPanel;
    JPanel tout;
    JPanel revealPanel;
    MoneyInputPanel money;
    MiseInputPanel mise;
    JButton button;

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
        Dimension dimLargeur = new Dimension(100, Integer.MAX_VALUE);
        cartePanel.setPreferredSize(dimHauteur);
        carteAdversPanel.setPreferredSize(dimHauteur);

        List<Carte> listCartes = new ArrayList<>();

        for (int i = 0; listCartes.size() < 5; i++) {
            boolean exist = false;
            Carte carte = new Carte();

            if (tab[carte.getLigne()][carte.getColonne()] == 0) {
                exist = true;
            } else {
                carte.setValeur(tab[carte.getLigne()][carte.getColonne()]);
                positionCarte(carte.getLigne(), carte.getColonne(), tab);
            }

            if (!exist) {
                listCartes.add(carte);
            }
        }

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
            frame.revalidate();
        });

        money = new MoneyInputPanel(money1 -> {
            mise = new MiseInputPanel(money1);
            mise.setPreferredSize(new Dimension(200, 400));

            tout.remove(buttonPanel);
            buttonPanel.add(button, BorderLayout.WEST);
            buttonPanel.add(mise, BorderLayout.EAST);
            tout.add(cartePanel, BorderLayout.SOUTH);
            tout.add(carteAdversPanel, BorderLayout.NORTH);
            tout.add(buttonPanel, BorderLayout.CENTER);

            frame.revalidate();
        });

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        Dimension dimButton = new Dimension(100, 100);
        buttonPanel.setPreferredSize(dimButton);
        buttonPanel.add(money);

        displayBoard(tab);

        tout.add(buttonPanel, BorderLayout.CENTER);

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
