package software.ulpgc.MoneyCalculator.apps.swing.dialogs;

import software.ulpgc.MoneyCalculator.architecture.view.ExceptionDialog;

import javax.swing.*;

public class SwingExceptionDialog extends JDialog implements ExceptionDialog {
    @Override
    public void showDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
