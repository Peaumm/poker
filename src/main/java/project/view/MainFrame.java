package project.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

    public MainFrame() {
        this.setTitle("Poker");
        this.setSize(1280, 720 );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        this.add(topPanel, BorderLayout.NORTH);

        add(mainPanel);
        cardLayout.show(mainPanel, "home");

    }

}

