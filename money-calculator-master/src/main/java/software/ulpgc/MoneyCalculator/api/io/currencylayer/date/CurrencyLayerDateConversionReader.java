package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.MoneyCalculator.api.io.currencylayer.CurrencyLayerApi;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.jsoup.Connection.Method.GET;

public class CurrencyLayerDateConversionReader implements DateConversionReader {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String ACCEPT = "accept";
    public static final String ALL_TEXT = "text/*";
    public static final int HTTP_OK = 200;

    @Override
    public String read(String fromCurrencyCode, String toCurrencyCode, ZonedDateTime date) throws IOException {
        return read(CurrencyLayerApi.getDateConversionEndpoint(fromCurrencyCode, toCurrencyCode, formatted(date)));
    }

    private String read(String dateExchangeRateEndpoint) throws IOException {
        Connection.Response response = Jsoup.connect(dateExchangeRateEndpoint)
                .ignoreContentType(true)
                .header(ACCEPT, ALL_TEXT)
                .method(GET)
                .execute();
        if (response.statusCode() != HTTP_OK) throw new RuntimeException();
        return response.body();
    }

    private String formatted(ZonedDateTime date) {
        return DateTimeFormatter.ofPattern(DATE_FORMAT).format(date);
    }
}
