package project.view.cartes;

import lombok.Getter;
import project.tool.Functions;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class CarteAdverse extends JPanel {
    private final BufferedImage image;
    private final BufferedImage carte;
    private final Image scaledImage;

    @Getter private final int ligne = Functions.alea(0,6);
    @Getter private final int colonne = Functions.alea(0, 7);

    public CarteAdverse() {
        try {
            InputStream fichierImage = getClass().getResourceAsStream("/images/back.jpg");
            if (fichierImage == null) {
                throw new Exception("Image non trouvé");
            }
            image = ImageIO.read(fichierImage);

            carte = image.getSubimage(
                60,
                0,
                283,
                400
            );

            ImageIcon originalIcon = new ImageIcon(carte);
            scaledImage = originalIcon.getImage().getScaledInstance(90, 145, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (scaledImage != null) {
            g.drawImage(scaledImage, 50, 50, null);
        }
    }
}
