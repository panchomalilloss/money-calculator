package software.ulpgc.MoneyCalculator.api.io.pojos;

import java.util.Map;

public record ExchangeRatesSymbolsGetResponse(boolean success, Map<String, String> symbols) {}
