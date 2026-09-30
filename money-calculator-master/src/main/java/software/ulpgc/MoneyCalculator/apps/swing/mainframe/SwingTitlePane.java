package software.ulpgc.MoneyCalculator.apps.swing.mainframe;

import javax.swing.*;
import java.awt.*;

public class SwingTitlePane {
    public static final Color LABEL_COLOR = Color.BLACK;
    public static final String LABEL_TEXT = "Money Calculator";
    private static final String FONT_NAME = "Agency FB";
    private final JPanel titlePane;

    public SwingTitlePane() {
        titlePane = new JPanel();
        titlePane.add(getTitleLabel());
    }

    private Component getTitleLabel() {
        JLabel titleLabel = new JLabel(LABEL_TEXT);
        titleLabel.setFont(getFont());
        titleLabel.setForeground(LABEL_COLOR);
        return titleLabel;
    }

    private Font getFont() {
        return new Font(FONT_NAME, Font.PLAIN, adaptFontSize());
    }

    private int adaptFontSize() {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 50;
    }

    public JPanel getTitlePane() {
        return this.titlePane;
    }
}
