package project.view.Input;

import project.tool.Functions;

import javax.swing.*;
import java.awt.*;

public class MoneyInputPanel extends JPanel {

    private JLabel resultLabel;
    private JTextField moneyField;
    private JLabel moneyLabel;
    private MoneyInputListener moneyListener;

    public MoneyInputPanel(MoneyInputListener listener) {
        this.moneyListener = listener;
        setLayout(new FlowLayout());

        moneyField = new JTextField(10);
        moneyLabel = new JLabel("Entrez votre somme :");
        add(moneyLabel);
        add(moneyField);

        JButton validateButton = new JButton("Valider");
        add(validateButton);

        resultLabel = new JLabel("Votre somme sera affichée ici.");
        add(resultLabel);

        validateButton.addActionListener(e -> {
            int money = Functions.setMoneyFromInput(resultLabel, moneyField);
            if (money > 0) {
                moneyListener.onMoneyDefined(money);
            }
            remove(moneyField);
            remove(validateButton);
            remove(resultLabel);
            remove(moneyLabel);
        });
    }

    public interface MoneyInputListener {
        void onMoneyDefined(int money);
    }
}
