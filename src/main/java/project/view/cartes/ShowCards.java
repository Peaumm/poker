package project.view.cartes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShowCards extends JPanel {

    public ShowCards () {
        JFrame frame = new JFrame();

        JPanel cartePanel = new JPanel();
        cartePanel.setLayout(new BoxLayout(cartePanel, BoxLayout.X_AXIS));
        List<Carte> listCartes = new ArrayList<>();

//        Carte carte = new Carte();
//        cartePanel.add(carte);

        for (int i = 0; i < 5; i++) {
            Carte carte = new Carte();
            listCartes.add(i, carte);
        }
        for (Carte carte : listCartes) {
            cartePanel.add(carte);
        }

        this.add(cartePanel, BorderLayout.WEST);

        frame.setTitle("Poker");
        frame.setSize(1280, 720 );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cartePanel);
        frame.setVisible(true);

    }
}
