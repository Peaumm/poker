package project.tool;

import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.im.InputContext;
import java.util.ArrayList;
import java.util.List;

public abstract class Functions {
  static Scanner scan = new Scanner(System.in);

  public static int alea(int min, int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }

  public static String demanderString(String question) {
    System.out.println(question);
    String reponse = scan.next();
    System.out.print("\n");
    return reponse;
  }

  public static int demanderInt(String question) {
    System.out.println(question);
    int reponse = scan.nextInt();
    System.out.print("\n");
    return reponse;
  }

  public static void setMoneyFromInput(JLabel resultLabel, JTextField moneyField) {
    String inputText = moneyField.getText();

    try {
        int money = Integer.parseInt(inputText);
        if (money < 0) {
            resultLabel.setText("Erreur : La somme ne peut pas être négative.");
        } else {
            resultLabel.setText("Somme saisie : " + money + " euros");
        }
    } catch (NumberFormatException ex) {
        resultLabel.setText("Erreur : Veuillez entrer un nombre valide.");
    }
}

}
