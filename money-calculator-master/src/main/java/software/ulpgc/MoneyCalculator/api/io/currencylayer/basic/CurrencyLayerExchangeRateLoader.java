package software.ulpgc.MoneyCalculator.api.io.currencylayer.basic;

import software.ulpgc.MoneyCalculator.architecture.io.adapters.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.io.readers.ExchangeRateReader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;

public class CurrencyLayerExchangeRateLoader implements ExchangeRateLoader {
    private final ExchangeRateReader reader;
    private final ExchangeRateDeserializer deserializer;
    private final ExchangeRateAdapter adapter;

    public CurrencyLayerExchangeRateLoader(ExchangeRateReader reader, ExchangeRateDeserializer deserializer, ExchangeRateAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency) throws IOException {
        return this.adapter.adapt(deserializer.deserialize(reader.read(fromCurrency.getCode(), toCurrency.getCode())), fromCurrency, toCurrency);
    }
}
