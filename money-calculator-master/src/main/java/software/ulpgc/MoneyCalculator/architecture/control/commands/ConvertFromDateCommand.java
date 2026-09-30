package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.io.loaders.DateExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;
import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
import software.ulpgc.MoneyCalculator.architecture.view.DateDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

import java.io.IOException;
import java.time.ZonedDateTime;

import static software.ulpgc.MoneyCalculator.architecture.control.commands.ConvertCommand.API_ERROR_TITLE;

public class ConvertFromDateCommand implements Command {

    private final CurrenciesDialog toCurrencyDialog;
    private final DateDialog dateDialog;
    private final MoneyDisplay display;
    private final MoneyDialog moneyDialog;
    private final DateExchangeRateLoader loader;

    public ConvertFromDateCommand(CurrenciesDialog toCurrencyDialog, DateDialog dateDialog, MoneyDisplay display, MoneyDialog moneyDialog, DateExchangeRateLoader loader) {
        this.toCurrencyDialog = toCurrencyDialog;
        this.dateDialog = dateDialog;
        this.display = display;
        this.moneyDialog = moneyDialog;
        this.loader = loader;
    }

    @Override
    public void execute() {
        try {
            if (!moneyDialog.isEmpty()) new DisplayConvertedMoneyCommand(this.display, getConvertedMoney()).execute();
        } catch (IOException ex) {
            DisplayExceptionCommand.with(ex.getMessage(), API_ERROR_TITLE).execute();
        }
    }

    private Money getConvertedMoney() throws IOException {
        return Money.getFrom(getAmount(), getToCurrency());
    }

    private double getAmount() throws IOException {
        return getMoneyAmount() * getRate();
    }

    private double getRate() throws IOException {
        return getExchangeRateLoader().getRate();
    }

    private double getMoneyAmount() {
        return moneyDialog.getMoney().amount();
    }

    private ExchangeRate getExchangeRateLoader() throws IOException {
        return loader.load(getFromCurrency(), getToCurrency(), getDate());
    }

    private ZonedDateTime getDate() {
        return dateDialog.getDate();
    }

    private Currency getToCurrency() {
        return toCurrencyDialog.getSelectedCurrency();
    }

    private Currency getFromCurrency() {
        return this.moneyDialog.getMoney().currency();
    }
}
