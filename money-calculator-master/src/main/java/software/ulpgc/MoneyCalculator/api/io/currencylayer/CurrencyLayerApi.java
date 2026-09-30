package software.ulpgc.MoneyCalculator.api.io.currencylayer;

public class CurrencyLayerApi {
    public static final String API_KEY = System.getenv("CURRENCYLAYER_API_KEY");
    private static final String EXCHANGE_RATE_ENDPOINT = "https://api.currencylayer.com/live?access_key=%s&source=%s&currencies=%s";
    private static final String DATE_CONVERSION_ENDPOINT = "https://api.currencylayer.com/convert?access_key=%s&from=%s&to=%s&amount=1&date=%s";

    public static String getExchangeRateEndpoint(String fromCurrency, String toCurrency) {
        return String.format(EXCHANGE_RATE_ENDPOINT, API_KEY, fromCurrency, toCurrency);
    }

    public static String getDateConversionEndpoint(String fromCurrency, String toCurrency, String date) {
        return String.format(DATE_CONVERSION_ENDPOINT, API_KEY, fromCurrency, toCurrency, date);
    }
}
