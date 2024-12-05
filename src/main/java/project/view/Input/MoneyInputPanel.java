package project.view.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import project.tool.Functions;

public class MoneyInputPanel extends JPanel { 

    private JLabel resultLabel;
    private JTextField moneyField;

    public MoneyInputPanel() {
        setLayout(new FlowLayout());

        moneyField = new JTextField(10);
        add(new JLabel("Entrez votre somme :"));
        add(moneyField);

        JButton validateButton = new JButton("Valider");
        add(validateButton);

        resultLabel = new JLabel("Votre somme sera affichée ici.");
        resultLabel.setHorizontalAlignment(SwingConstants.LEFT);
        resultLabel.setForeground(Color.BLACK);
        add(resultLabel);

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions.setMoneyFromInput(resultLabel, moneyField);
            }
        });
    }
}
