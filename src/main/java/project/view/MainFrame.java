package project.view;

import project.view.cartes.ShowCards;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Poker");
        setSize(1280, 720 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new ShowCards());

        setVisible(true);
    }

}

