package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerDateConversionGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerGetResponseError;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.ExchangeRateAdapter;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;
import software.ulpgc.MoneyCalculator.architecture.model.ExchangeRate;

import java.io.IOException;
import java.time.LocalDate;

public class CurrencyLayerDateExchangeRateAdapter implements ExchangeRateAdapter {
    @Override
    public ExchangeRate adapt(Object object, Currency fromCurrency, Currency toCurrency) throws IOException {
        try {
            CurrencyLayerDateConversionGetResponse response = (CurrencyLayerDateConversionGetResponse) object;
            return adapt(response.info().timestamp(), response.result(), fromCurrency, toCurrency);
        } catch (ClassCastException ex) {
            throw (object instanceof CurrencyLayerGetResponseError responseError)
                    ? new IOException(responseError.error().info())
                    : new IOException(ex.getMessage());
        }
    }

    private ExchangeRate adapt(long timestamp, double exchangeRate, Currency fromCurrency, Currency toCurrency) {
        return new ExchangeRate(getLocalDate(timestamp), exchangeRate, fromCurrency, toCurrency);
    }

    private LocalDate getLocalDate(long timestamp) {
        return LocalDate.EPOCH.plusDays(getDays(timestamp));
    }

    private long getDays(long timestamp) {
        return timestamp / 86400;
    }
}
