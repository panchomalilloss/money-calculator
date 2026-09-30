package software.ulpgc.MoneyCalculator.apps.swing.dialogs;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingCurrenciesDialog extends JComboBox<Currency> implements CurrenciesDialog {

    public static final int FONT_SIZE = 15;
    public static final String FONT_NAME = "FB Agent";
    public static final Font FONT = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE);
    public static final int WIDTH = 350;
    public static final int HEIGHT = 30;
    public static final Color BACKGROUND_COLOR = Color.RED;

    public SwingCurrenciesDialog() {
        super();
        this.setFont(FONT);
        this.setAlignmentX(CENTER_ALIGNMENT);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(BACKGROUND_COLOR);
    }

    @Override
    public void display(List<Currency> currencies) {
        for (Currency currency : currencies) {
            this.addItem(new Currency(currency.getCode(), currency.getName(), currency.getSymbol()) {
                @Override
                public String toString() {
                    return getName() + "(" + getCode() + " - " + getSymbol() + ")";
                }
            });
        }
    }

    @Override
    public Currency getSelectedCurrency() {
        return (Currency) this.getSelectedItem();
    }

    @Override
    public void setCurrency(Currency currency) {
        this.setSelectedItem(currency);
    }
}
