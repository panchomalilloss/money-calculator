package software.ulpgc.MoneyCalculator.architecture.io;

import java.util.Map;

public record CurrencyCodesToSymbols(Map<String, String> codesToSymbols) {
    public String getOrDefault(Object key, String defaultValue) {
        return codesToSymbols.getOrDefault(key, defaultValue);
    }
}
