package software.ulpgc.MoneyCalculator.apps.swing.date.conversion;

import software.ulpgc.MoneyCalculator.apps.swing.displays.SwingMoneyDisplay;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingCurrenciesDialog;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingMoneyDialog;
import software.ulpgc.MoneyCalculator.apps.swing.dialogs.SwingDateDialog;
import software.ulpgc.MoneyCalculator.apps.swing.mainframe.SwingMainFrame;
import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SwingDateMoneyConversionFrame extends JFrame {

    public static final int BUTTON_HEIGHT = 30;
    public static final int BUTTON_WIDTH = 200;
    public static final Color BUTTON_BACKGROUND_COLOR = Color.RED;
    public static final Color BACKGROUND_COLOR = Color.RED;
    public static final String ICON_PNG = "/icon.png";
    private static final String BUTTON_LABEL = "Convert";
    private static final String BUTTON_COMMAND = "convert";
    private static final String TITLE_TEXT = "Date conversion";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 300;
    private static final Color BUTTON_BORDER_COLOR = Color.BLACK;
    private static final int BUTTON_BORDER_THICKNESS = 2;
    private final Map<String, Command> commands;
    private CurrenciesDialog fromCurrenciesDialog;
    private CurrenciesDialog toCurrenciesDialog;
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;
    private DateDialog dateDialog;

    public SwingDateMoneyConversionFrame(List<Currency> currencies) throws HeadlessException, IOException {
        this.commands = new HashMap<>();
        initFrame();
        this.add(topPanel(currencies));
        this.add(bottomPanel());
    }

    private Component bottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(BACKGROUND_COLOR);
        getMoneyDialogPanel();
        bottomPanel.add(getMoneyDialogPanel());
        bottomPanel.add(getDateDialogPanel());
        bottomPanel.add(getConvertButtonPanel());
        bottomPanel.add(getMoneyDisplayPanel());
        return bottomPanel;
    }

    private Component getMoneyDisplayPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        moneyDisplay = new SwingMoneyDisplay();
        jPanel.add((Component) moneyDisplay);
        return jPanel;
    }

    private JPanel getMoneyDialogPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        moneyDialog = new SwingMoneyDialog(this.fromCurrenciesDialog);
        jPanel.add((Component) moneyDialog);
        return jPanel;
    }

    private Component getDateDialogPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        this.dateDialog = new SwingDateDialog();
        jPanel.add((Component) dateDialog);
        return jPanel;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }

    private void initFrame() throws IOException {
        this.setTitle(TITLE_TEXT);
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(2, 1));
        this.setBackground(BACKGROUND_COLOR);
        this.setIconImage(getIcon());
    }

    private Image getIcon() throws IOException {
        return getIconAsImage();
    }

    private Image getIconAsImage() throws IOException {
        try (InputStream iconAsStream = SwingMainFrame.class.getResourceAsStream(ICON_PNG)) {
            return ImageIO.read(Objects.requireNonNull(iconAsStream));
        }
    }

    private Component topPanel(List<Currency> currencies) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2));
        jPanel.add(getFromCurrenciesPanel(currencies));
        jPanel.add(getToCurrenciesPanel(currencies));
        return jPanel;
    }

    private Component getToCurrenciesPanel(List<Currency> currencies) {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        toCurrenciesDialog = new SwingCurrenciesDialog();
        toCurrenciesDialog.display(currencies);
        jPanel.add((Component) toCurrenciesDialog);
        return jPanel;
    }

    private Component getFromCurrenciesPanel(List<Currency> currencies) {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        fromCurrenciesDialog = new SwingCurrenciesDialog();
        fromCurrenciesDialog.display(currencies);
        jPanel.add((Component) fromCurrenciesDialog);
        return jPanel;
    }

    private Component getConvertButtonPanel() {
        JPanel jPanel = new JPanel();
        jPanel.setBackground(BACKGROUND_COLOR);
        JButton button = new JButton(BUTTON_LABEL);
        button.addActionListener(e -> this.commands.get(BUTTON_COMMAND).execute());
        button.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setBackground(BUTTON_BACKGROUND_COLOR);
        button.setBorder(new LineBorder(BUTTON_BORDER_COLOR, BUTTON_BORDER_THICKNESS));
        jPanel.add(button);
        return jPanel;
    }

    public CurrenciesDialog getToCurrenciesDialog() {
        return toCurrenciesDialog;
    }

    public DateDialog getDateDialog() {
        return dateDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }
}
