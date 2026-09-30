package software.ulpgc.MoneyCalculator.architecture.io.readers;

import java.io.IOException;

public interface ExchangeRateReader {
    String read(String fromCurrencyCode, String toCurrencyCode) throws IOException;
}
