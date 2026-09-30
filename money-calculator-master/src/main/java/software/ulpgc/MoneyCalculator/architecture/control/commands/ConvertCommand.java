    package software.ulpgc.MoneyCalculator.architecture.control.commands;

    import software.ulpgc.MoneyCalculator.architecture.io.loaders.ExchangeRateLoader;
    import software.ulpgc.MoneyCalculator.architecture.model.Currency;
    import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;
    import software.ulpgc.MoneyCalculator.architecture.model.Money;
    import software.ulpgc.MoneyCalculator.architecture.view.CurrenciesDialog;
    import software.ulpgc.MoneyCalculator.architecture.view.MoneyDialog;
    import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

    import java.io.IOException;

    public class ConvertCommand implements Command {

        public static final String API_ERROR_TITLE = "API ERROR";
        private final CurrenciesDialog toCurrencyDialog;
        private final MoneyDialog dialog;
        private final MoneyDisplay display;
        private final ExchangeRateLoader loader;

        public ConvertCommand(CurrenciesDialog toCurrenciesDialog, MoneyDialog dialog, MoneyDisplay display, ExchangeRateLoader loader) {
            this.toCurrencyDialog = toCurrenciesDialog;
            this.dialog = dialog;
            this.display = display;
            this.loader = loader;
        }

        @Override
        public void execute() {
            try {
                if (!dialog.isEmpty()) new DisplayConvertedMoneyCommand(display, getConvertedMoney()).execute();
            } catch (IOException ex) {
                DisplayExceptionCommand.with(ex.getMessage(), API_ERROR_TITLE).execute();
            } catch (NullPointerException ex) {
                new DisplayConvertedMoneyCommand(display, this.dialog.getMoney()).execute();
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

        private Currency getToCurrency() {
            return toCurrencyDialog.getSelectedCurrency();
        }

        private ExchangeRate getExchangeRateLoader() throws IOException {
            return loader.load(this.dialog.getMoney().currency(), getToCurrency());
        }

        private double getMoneyAmount() {
            return dialog.getMoney().amount();
        }
    }
