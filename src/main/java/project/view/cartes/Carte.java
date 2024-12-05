package project.view.cartes;

import lombok.Getter;
import lombok.Setter;
import project.tool.Functions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Carte extends JPanel {
    private BufferedImage image;
    private final BufferedImage carte;

    @Getter private int ligne = Functions.alea(0,6);
    @Getter private int colonne = Functions.alea(0, 7);
    @Getter @Setter private int valeur;

    public Carte() {
        try {
            InputStream fichierImage = getClass().getResourceAsStream("/images/cartes.jpg");
            if (fichierImage == null) {
                throw new Exception("Image non trouvé");
            }
            image = ImageIO.read(fichierImage);

            int largeurCarte = 95;
            int hauteurCarte = 145;

            carte = image.getSubimage(
                colonne * (largeurCarte + 34) + 35,
                ligne * (hauteurCarte + 35) + 35,
                largeurCarte, hauteurCarte
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Carte(int valeur) {
        try {
            InputStream fichierImage = getClass().getResourceAsStream("/images/cartes.jpg");
            if (fichierImage == null) {
                throw new Exception("Image non trouvé");
            }
            image = ImageIO.read(fichierImage);

            ligne = (valeur-1) / 8;
            colonne = (valeur-1) % 8;

            int largeurCarte = 95;
            int hauteurCarte = 145;

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
}
