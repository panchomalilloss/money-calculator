    package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

    import software.ulpgc.MoneyCalculator.apps.swing.date.conversion.SwingDateMoneyConversionFrame;
    import software.ulpgc.MoneyCalculator.architecture.control.commands.Command;
    import software.ulpgc.MoneyCalculator.architecture.model.Currency;
    import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
    import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
    import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

    import javax.imageio.ImageIO;
    import javax.swing.*;
    import java.awt.*;
    import java.io.IOException;
    import java.io.InputStream;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Objects;

    public class SwingMainFrame extends JFrame {

        public static final Color BACKGROUND_COLOR = Color.RED;
        public static final String ICON_PNG = "/icon.png";
        private static final int WIDTH = 1080;
        private static final int HEIGHT = 270;
        private static final String TITLE = "Money Calculator";
        private static final String JMENU_ITEM_TEXT = "Date Money Conversion";
        private static final String JMENU_TEXT = "Date Operations";
        private final List<Currency> currencies;
        private final HashMap<String, Command> commands;
        private final SwingDateMoneyConversionFrame swingDateMoneyConversionFrame;
        private SwingCurrenciesDialogsPane swingCurrenciesDialogsPane;
        private SwingConversionPane swingConversionPane;

        public SwingMainFrame(List<Currency> currencies) throws HeadlessException, IOException {
            super();
            this.currencies = currencies;
            this.commands = new HashMap<>();
            this.swingDateMoneyConversionFrame = new SwingDateMoneyConversionFrame(currencies);
            initFrame();
        }

        public SwingDateMoneyConversionFrame getDateMoneyConversionFrame() {
            return swingDateMoneyConversionFrame;
        }

        private void initFrame() throws IOException {
            setFrameSettings();
            addPanels();
        }

        private void setFrameSettings() throws IOException {
            this.setTitle(TITLE);
            this.setSize(WIDTH, HEIGHT);
            this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
            this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
            this.setLocationRelativeTo(null);
            this.setLayout(new GridLayout(3, 1, 5, 5));
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setJMenuBar(buildJMenuBar());
            this.getContentPane().setBackground(BACKGROUND_COLOR);
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

        private void addPanels() {
            this.add(titlePane());
            this.add(currenciesDialogPane());
            this.add(conversionPane());
        }

        private Component titlePane() {
            JPanel titlePane = new SwingTitlePane().getTitlePane();
            titlePane.setBackground(BACKGROUND_COLOR);
            return titlePane;
        }

        private JMenuBar buildJMenuBar() {
            JMenuBar jMenuBar = new JMenuBar();
            jMenuBar.setBackground(BACKGROUND_COLOR);
            jMenuBar.add(getJMenu());
            return jMenuBar;
        }

        private Component currenciesDialogPane() {
            swingCurrenciesDialogsPane = new SwingCurrenciesDialogsPane(currencies, commands);
            return swingCurrenciesDialogsPane.getCurrenciesDialogsPane();
        }

        private Component conversionPane() {
            swingConversionPane = new SwingConversionPane(commands, getFromCurrency());
            return swingConversionPane.getConversionPane();
        }

        private Component getJMenu() {
            JMenu jMenu = new JMenu(JMENU_TEXT);
            jMenu.setBackground(BACKGROUND_COLOR);
            jMenu.add(buildJMenuItem());
            return jMenu;
        }

        public CurrenciesDialog getFromCurrency() {
            return swingCurrenciesDialogsPane.getFromCurrency();
        }

        private JMenuItem buildJMenuItem() {
            JMenuItem jMenuItem = new JMenuItem(JMENU_ITEM_TEXT);
            jMenuItem.setBackground(BACKGROUND_COLOR);
            jMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            jMenuItem.addActionListener(e -> {
                swingDateMoneyConversionFrame.setVisible(true);
                swingDateMoneyConversionFrame.setLocationRelativeTo(SwingMainFrame.this);
            });
            return jMenuItem;
        }

        public SwingMainFrame putOnMainFrameCommands(String key, Command value) {
            commands.put(key, value);
            return this;
        }

        public SwingMainFrame putOnDateConversionFrameCommands(String key, Command value) {
            swingDateMoneyConversionFrame.put(key, value);
            return this;
        }

        public CurrenciesDialog getToCurrency() {
            return swingCurrenciesDialogsPane.getToCurrency();
        }

        public MoneyDialog getMoneyDialog() {
            return swingConversionPane.getMoneyDialog();
        }

        public MoneyDisplay getMoneyDisplay() {
            return swingConversionPane.getMoneyDisplay();
        }
    }
