package software.ulpgc.MoneyCalculator.api.io.pojos;

import java.util.Map;

public record CurrencyLayerExchangeRateGetResponse(boolean success, String terms, String privacy, long timestamp, String source, Map<String, Double> quotes) {
}
