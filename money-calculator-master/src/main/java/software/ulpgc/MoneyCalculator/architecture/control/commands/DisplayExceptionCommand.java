package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.view.ExceptionDialog;

public class DisplayExceptionCommand implements Command {

    private static ExceptionDialog dialog;
    private final String message;
    private final String title;

    private DisplayExceptionCommand(String message, String title) {
        this.message = message;
        this.title = title;
    }

    public static void initializeDialog(ExceptionDialog dialogInstance) {
        if (dialog == null) {
            dialog = dialogInstance;
        }
    }

    public static DisplayExceptionCommand with(String message, String title) {
        return new DisplayExceptionCommand(message, title);
    }

    @Override
    public void execute() {
        dialog.showDialog(message, title);
    }
}
