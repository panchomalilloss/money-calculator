package software.ulpgc.MoneyCalculator.api.io.currencylayer.basic;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.CurrencyLayerApi;
import software.ulpgc.MoneyCalculator.architecture.io.readers.ExchangeRateReader;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class CurrencyLayerExchangeRateReader implements ExchangeRateReader {

    public static final String ACCEPT = "accept";
    public static final String ALL_TEXT = "text/*";
    public static final int HTTP_OK = 200;

    @Override
    public String read(String fromCurrencyCode, String toCurrencyCode) throws IOException {
        return read(CurrencyLayerApi.getExchangeRateEndpoint(fromCurrencyCode, toCurrencyCode));
    }

    private String read(String exchangeRateEndpoint) throws IOException {
        Connection.Response response = Jsoup.connect(exchangeRateEndpoint)
                .ignoreContentType(true)
                .header(ACCEPT, ALL_TEXT)
                .method(GET)
                .execute();
        if (response.statusCode() != HTTP_OK) throw new RuntimeException();
        return response.body();
    }
}
