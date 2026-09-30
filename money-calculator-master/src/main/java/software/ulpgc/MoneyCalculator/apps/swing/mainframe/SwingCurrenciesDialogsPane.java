package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingCurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SwingCurrenciesDialogsPane {

    public static final ImageIcon BUTTON_ICON = new ImageIcon(Objects.requireNonNull(SwingCurrenciesDialogsPane.class.getResource("/exchange_arrows.png")));
    public static final String EXCHANGE_COMMAND = "exchange";
    public static final Color BACKGROUND_COLOR = Color.RED;
    public static final Color BUTTON_BORDER_COLOR = Color.BLACK;
    public static final int BUTTON_BORDER_THICKNESS = 3;
    public static final int HEIGHT = 30;
    public static final int WIDTH = 200;
    public static final int ROWS = 1;
    public static final int COLUMNS = 3;
    public static final int HGAP = 10;
    public static final int VGAP = 10;
    private final JPanel currenciesDialogsPane;
    private final CurrenciesDialog fromCurrency;
    private final CurrenciesDialog toCurrency;
    private final List<Currency> currencies;
    private final Map<String, Command> commands;

    public SwingCurrenciesDialogsPane(List<Currency> currencies, Map<String, Command> commands) {
        this.currencies = currencies;
        this.commands = commands;
        fromCurrency = new SwingCurrenciesDialog();
        toCurrency = new SwingCurrenciesDialog();
        currenciesDialogsPane = new JPanel();
        initPanel();
    }

    private void initPanel() {
        currenciesDialogsPane.setLayout(new GridLayout(ROWS, COLUMNS, HGAP, VGAP));
        currenciesDialogsPane.setBackground(BACKGROUND_COLOR);
        addPanels();
    }

    private void addPanels() {
        currenciesDialogsPane.add(fromCurrencyPanel());
        currenciesDialogsPane.add(exchangeButtonPanel());
        currenciesDialogsPane.add(toCurrencyPanel());
    }

    private Component fromCurrencyPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);
        panel.add((Component) fromCurrency);
        return panel;
    }

    private Component exchangeButtonPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);
        JButton button = new JButton();
        button.setIcon(BUTTON_ICON);
        button.addActionListener(e -> commands.get(EXCHANGE_COMMAND).execute());
        button.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        button.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        button.setBackground(BACKGROUND_COLOR);
        button.setBorder(new LineBorder(BUTTON_BORDER_COLOR, BUTTON_BORDER_THICKNESS));
        panel.add(button);
        return panel;
    }

    private Component toCurrencyPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);
        panel.add((Component) toCurrency);
        return panel;
    }

    public JPanel getCurrenciesDialogsPane() {
        fromCurrency.display(currencies);
        toCurrency.display(currencies);
        return currenciesDialogsPane;
    }

    public CurrenciesDialog getFromCurrency() {
        return fromCurrency;
    }

    public CurrenciesDialog getToCurrency() {
        return toCurrency;
    }

}
