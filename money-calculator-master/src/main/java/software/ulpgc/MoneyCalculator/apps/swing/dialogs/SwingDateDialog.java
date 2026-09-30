package software.ulpgc.MoneyCalculator.apps.swing.dialogs;

import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class SwingDateDialog extends JSpinner implements DateDialog {
    public static final String DATE_PATTERN = "dd/MM/yyyy";
    public static final SpinnerDateModel SPINNER_DATE_MODEL = new SpinnerDateModel();
    public static final Color BACKGROUND_COLOR = Color.RED;

    public SwingDateDialog() {
        super(SPINNER_DATE_MODEL);
        this.setEditor(new DateEditor(this, DATE_PATTERN));
        setComponentBackground();
    }

    private void setComponentBackground() {
        this.setBackground(BACKGROUND_COLOR);
        this.setOpaque(true);
        JComponent editor = this.getEditor();
        JSpinner.DefaultEditor defaultEditor = (JSpinner.DefaultEditor) editor;
        defaultEditor.getTextField().setBackground(BACKGROUND_COLOR);
        defaultEditor.getTextField().setOpaque(true);
    }

    @Override
    public ZonedDateTime getDate() {
        Instant instant = ( (Date) this.getValue()).toInstant();
        return ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
