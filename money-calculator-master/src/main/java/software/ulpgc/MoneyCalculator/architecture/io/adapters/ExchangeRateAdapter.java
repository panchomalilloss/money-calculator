package software.ulpgc.MoneyCalculator.architecture.io.adapters;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;

public interface ExchangeRateAdapter {
    ExchangeRate adapt(Object object, Currency from, Currency to) throws IOException;
}
