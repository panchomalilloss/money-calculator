package software.ulpgc.MoneyCalculator.architecture.io.loaders;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;
import java.time.ZonedDateTime;

public interface DateExchangeRateLoader {
    ExchangeRate load(Currency fromCurrency, Currency toCurrency, ZonedDateTime date) throws IOException;
}
