package project.view.cartes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.InputStream;
import javax.imageio.ImageIO;  
import java.awt.image.BufferedImage;  
import javax.swing.JPanel;

public class Carte extends JPanel {
    private BufferedImage image;
    private final BufferedImage carte;
    private boolean selected = false;  

    private final int ligne;
    private final int colonne;

    public Carte(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;

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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selected = !selected; 
                repaint();  
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (carte != null) {
            g.drawImage(carte, 0, 0, null);
        }

        if (selected) {
            g.setColor(Color.RED);
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1); 
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
}
