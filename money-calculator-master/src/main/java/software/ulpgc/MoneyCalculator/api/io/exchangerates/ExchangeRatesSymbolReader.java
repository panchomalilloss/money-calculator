package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

import static org.jsoup.Connection.Method.GET;

public class ExchangeRatesSymbolReader implements SymbolReader {

    public static final String ACCEPT = "accept";
    public static final String ALL_TEXT = "text/*";
    public static final int HTTP_OK = 200;

    @Override
    public String read() {
        try {
            Connection.Response response = Jsoup.connect(ExchangeRatesApi.SymbolEndpoint + ExchangeRatesApi.apiKey)
                    .ignoreContentType(true)
                    .header(ACCEPT, ALL_TEXT)
                    .method(GET)
                    .execute();
            if (response.statusCode() != HTTP_OK) throw new RuntimeException();
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
