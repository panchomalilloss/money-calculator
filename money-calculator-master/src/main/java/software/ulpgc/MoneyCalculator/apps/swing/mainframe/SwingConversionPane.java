package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingMoneyDialog;
import software.ulpgc.MoneyCalculator.apps.swing.displays.SwingMoneyDisplay;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Map;

public class SwingConversionPane {

    public static final String BUTTON_TAG = "Convert";
    public static final String BUTTON_COMMAND = "convert";
    public static final Font FONT = new Font("FB Agent", Font.PLAIN, 15);
    public static final int ROWS = 1;
    public static final int COLUMNS = 3;
    public static final int HORIZONTAL_GAP = 10;
    public static final int VERTICAL_GAP = 10;
    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = 30;
    public static final Color BACKGROUND_COLOR = Color.RED;
    public static final int BUTTON_BORDER_THICKNESS = 3;
    public static final Color BUTTON_BORDER_COLOR = Color.BLACK;
    private final JPanel conversionPane;
    private final Map<String, Command> commands;
    private final CurrenciesDialog fromCurrenciesDialog;
    private MoneyDisplay moneyDisplay;
    private MoneyDialog moneyDialog;

    public SwingConversionPane(Map<String, Command> commands, CurrenciesDialog fromCurrenciesDialog) {
        this.commands = commands;
        this.fromCurrenciesDialog = fromCurrenciesDialog;
        conversionPane = new JPanel();
        initPane();
    }

    private void initPane() {
        conversionPane.setLayout(new GridLayout(ROWS, COLUMNS, HORIZONTAL_GAP, VERTICAL_GAP));
        conversionPane.setBackground(BACKGROUND_COLOR);
        addPanels();
    }

    private void addPanels() {
        conversionPane.add(moneyDialogPanel());
        conversionPane.add(convertButtonPanel());
        conversionPane.add(moneyDisplayPanel());
    }

    private Component moneyDialogPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        moneyDialog = new SwingMoneyDialog(fromCurrenciesDialog);
        jPanel.add((Component) moneyDialog);
        return jPanel;
    }

    private Component convertButtonPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        JButton button = new JButton(BUTTON_TAG);
        button.addActionListener(e -> commands.get(BUTTON_COMMAND).execute());
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setFont(FONT);
        button.setBackground(BACKGROUND_COLOR);
        button.setBorder(new LineBorder(BUTTON_BORDER_COLOR, BUTTON_BORDER_THICKNESS));
        jPanel.add(button);
        return jPanel;
    }

    private Component moneyDisplayPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        this.moneyDisplay = new SwingMoneyDisplay();
        jPanel.add((Component) moneyDisplay);
        return jPanel;
    }

    protected JPanel getConversionPane() {
        return conversionPane;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
}
