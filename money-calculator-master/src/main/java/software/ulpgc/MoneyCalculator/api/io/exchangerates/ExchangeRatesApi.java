package software.ulpgc.MoneyCalculator.api.io.exchangerates;

public class ExchangeRatesApi {
    public static final String apiKey = System.getenv("EXCHANGERATES_API_KEY");
    public static final String SymbolEndpoint = "http://api.exchangeratesapi.io/v1/symbols?access_key=";
}
