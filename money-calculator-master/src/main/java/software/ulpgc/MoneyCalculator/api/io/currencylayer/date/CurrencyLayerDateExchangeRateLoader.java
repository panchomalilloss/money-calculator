package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import software.ulpgc.MoneyCalculator.architecture.io.adapters.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.DateExchangeRateLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;
import java.time.ZonedDateTime;

public class CurrencyLayerDateExchangeRateLoader implements DateExchangeRateLoader {

    private final DateConversionReader reader;
    private final DateConversionDeserializer deserializer;
    private final ExchangeRateAdapter adapter;

    public CurrencyLayerDateExchangeRateLoader(DateConversionReader reader, DateConversionDeserializer deserializer, ExchangeRateAdapter adapter) {
        this.reader = reader;
        this.deserializer = deserializer;
        this.adapter = adapter;
    }

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency, ZonedDateTime date) throws IOException {
        return this.adapter.adapt(deserializer.deserialize(reader.read(fromCurrency.getCode(), toCurrency.getCode(), date)), fromCurrency, toCurrency);
    }
}
