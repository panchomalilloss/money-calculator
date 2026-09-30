package software.ulpgc.MoneyCalculator.apps.swing.dialogs;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SwingMoneyDialog extends JTextField implements MoneyDialog {

    public static final int HEIGHT = 30;
    public static final int WIDTH = 100;
    public static final int COLUMNS = 15;
    public static final Color BACKGROUND_COLOR = Color.RED;
    public static final Color BORDER_COLOR = Color.BLACK;
    private static final int FONT_SIZE = 15;
    private static final String FONT_NAME = "FB Agent";
    private static final Font FONT = new Font(FONT_NAME, Font.PLAIN, FONT_SIZE);
    private final CurrenciesDialog currenciesDialog;
    private final String PLACEHOLDER  = "Type your amount here...";
    
    public SwingMoneyDialog(CurrenciesDialog currenciesDialog) {
        super(COLUMNS);
        this.currenciesDialog = currenciesDialog;
        this.initPlaceholder();
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setFont(FONT);
        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(new LineBorder(BORDER_COLOR, 2));
    }

    private static String getAmount(Money money) {
        return String.valueOf(money.amount());
    }

    @Override
    public Money getMoney() {
        return new Money(toDouble(this.getText()), currenciesDialog.getSelectedCurrency());
    }

    @Override
    public void setMoney(Money money) {
        this.setText(getAmount(money));
    }

    @Override
    public boolean isEmpty() {
        return this.getText().equals(PLACEHOLDER);
    }

    private double toDouble(String amount) {
        return Double.parseDouble(amount);
    }

    private void initPlaceholder() {
        setText(PLACEHOLDER);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (isPlaceholderDisplayed()) setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (isDialogEmpty()) setText(PLACEHOLDER);
            }
        });
    }

    private boolean isDialogEmpty() {
        return getText().isEmpty();
    }

    private boolean isPlaceholderDisplayed() {
        return getText().equals(PLACEHOLDER);
    }
}
