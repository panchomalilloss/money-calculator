package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;


public class SwapCurrenciesDialogCommand implements Command {
    private final CurrenciesDialog fromCurrencyDialog;
    private final CurrenciesDialog toCurrencyDialog;
    private final Currency fromCurrency;
    private final Currency toCurrency;

    public SwapCurrenciesDialogCommand(CurrenciesDialog fromCurrencyDialog, CurrenciesDialog toCurrencyDialog) {
        this.fromCurrencyDialog = fromCurrencyDialog;
        this.toCurrencyDialog = toCurrencyDialog;
        this.fromCurrency = fromCurrencyDialog.getSelectedCurrency();
        this.toCurrency = toCurrencyDialog.getSelectedCurrency();
    }

    @Override
    public void execute() {
        this.fromCurrencyDialog.setCurrency(toCurrency);
        this.toCurrencyDialog.setCurrency(fromCurrency);
    }
}
