package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import software.ulpgc.MoneyCalculator.architecture.io.loaders.CurrenciesLoader;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.util.List;

public class ExchangeRatesCurrenciesLoader implements CurrenciesLoader {
    private final SymbolReader reader;
    private final SymbolDeserializer deserializer;
    private final CurrencyAdapter adapter;

    public ExchangeRatesCurrenciesLoader(SymbolReader reader, SymbolDeserializer deserializer, CurrencyAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    public List<Currency> loadCurrencies() {
        return adapter.adapt(deserializer.deserialize(reader.read()));

    }
}
