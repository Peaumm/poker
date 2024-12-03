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

        for (int i = 0; listCartes.size() < 5; i++) {
            boolean exist = false;
            Carte carte = new Carte();
            for (Carte listCarte : listCartes) {
                if ((int) listCarte.listPosition.get(0) == (int) carte.listPosition.get(0)) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                listCartes.add(carte);
            }
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
