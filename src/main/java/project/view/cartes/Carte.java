package project.view.cartes;

import project.tool.Functions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Carte extends JPanel {
    private BufferedImage image;
    private BufferedImage carte;
    public List<Integer> listPosition = new ArrayList<>();

    public Carte() {
        try {
            InputStream fichierImage = getClass().getResourceAsStream("/images/cartes.jpg");
            if (fichierImage == null) {
                throw new Exception("Image non trouvé");
            }
            image = ImageIO.read(fichierImage);

            int largeurCarte = 95;
            int hauteurCarte = 145;
            int ligne = Functions.alea(0,6);
            int colonne = Functions.alea(0, 7);

            positionCarte(ligne, colonne);

            carte = image.getSubimage(
                colonne * (largeurCarte + 34) + 35,
                ligne * (hauteurCarte + 35) + 35,
                largeurCarte, hauteurCarte
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (carte != null) {
            g.drawImage(carte, 50, 50, null);
        }
    }

    public void positionCarte(int ligne, int colonne) {
        listPosition.add((colonne + 1) + (ligne * 8));
    }
}
