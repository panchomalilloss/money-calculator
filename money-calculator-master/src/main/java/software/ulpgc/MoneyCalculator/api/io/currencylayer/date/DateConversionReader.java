package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import java.io.IOException;
import java.time.ZonedDateTime;

public interface DateConversionReader {
    String read(String fromCurrencyCode, String toCurrencyCode, ZonedDateTime date) throws IOException;
}
