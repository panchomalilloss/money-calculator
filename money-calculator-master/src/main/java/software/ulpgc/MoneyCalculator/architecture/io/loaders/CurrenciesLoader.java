package software.ulpgc.MoneyCalculator.architecture.io.loaders;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.util.List;

public interface CurrenciesLoader {
    List<Currency> loadCurrencies();
}
