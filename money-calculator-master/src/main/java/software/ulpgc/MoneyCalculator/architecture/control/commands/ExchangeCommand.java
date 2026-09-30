package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;


public class ExchangeCommand implements Command {

    private final CurrenciesDialog fromCurrencyDialog;
    private final CurrenciesDialog toCurrencyDialog;
    private final MoneyDialog dialog;
    private final MoneyDisplay display;

    public ExchangeCommand(CurrenciesDialog fromCurrencyDialog, CurrenciesDialog toCurrencyDialog, MoneyDialog dialog, MoneyDisplay display) {
        this.fromCurrencyDialog = fromCurrencyDialog;
        this.toCurrencyDialog = toCurrencyDialog;
        this.dialog = dialog;
        this.display = display;
    }

    @Override
    public void execute() {
        if (AreDialogAndDisplayAvailableForSwapping()) new SwapMoneyDisplayAndDialogCommand(display, dialog).execute();
        new SwapCurrenciesDialogCommand(fromCurrencyDialog, toCurrencyDialog).execute();
    }

    private boolean AreDialogAndDisplayAvailableForSwapping() {
        return !this.dialog.isEmpty() && !this.display.isEmpty();
    }
}
