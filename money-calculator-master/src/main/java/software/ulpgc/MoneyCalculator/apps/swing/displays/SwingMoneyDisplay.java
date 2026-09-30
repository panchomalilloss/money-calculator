package software.ulpgc.MoneyCalculator.apps.swing.displays;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {

    private static final int FONT_SIZE = 15;
    private static final String MONEY_PROPERTY = "money";
    private static final String FONT_NAME = "FB Agent";
    private static final Font FONT = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE);


    public SwingMoneyDisplay() {
        super();
        this.setFont(FONT);
        this.setAlignmentX(CENTER_ALIGNMENT);
    }

    private static double getRoundedAmount(Money money) {
        BigDecimal amount = BigDecimal.valueOf(money.amount());
        BigDecimal roundedAmount = amount.setScale(2, RoundingMode.DOWN);
        return roundedAmount.doubleValue();
    }

    @Override
    public void display(Money money) {
        this.setText(getRoundedAmount(money) + " " + money.currency().getCode());
        this.putClientProperty(MONEY_PROPERTY, money);
    }

    @Override
    public Money getMoney() {
        return (Money) this.getClientProperty(MONEY_PROPERTY);
    }

    @Override
    public boolean isEmpty() {
        return this.getText().isEmpty();
    }
}
