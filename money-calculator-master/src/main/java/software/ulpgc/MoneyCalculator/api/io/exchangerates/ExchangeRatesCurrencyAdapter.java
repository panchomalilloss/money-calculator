package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import software.ulpgc.MoneyCalculator.api.io.pojos.ExchangeRatesSymbolsGetResponse;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.CsvCodeAndSymbolDeserializer;
import software.ulpgc.MoneyCalculator.architecture.io.adapters.CurrencyAdapter;
import software.ulpgc.MoneyCalculator.architecture.io.CurrencyCodesToSymbols;
import software.ulpgc.MoneyCalculator.architecture.io.loaders.FileCurrencyCodeToSymbolListLoader;
import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRatesCurrencyAdapter implements CurrencyAdapter {

    public static final String CURRENCY_CODE_TO_SYMBOL_CSV = "/currency_code_to_symbol.csv";
    public static final String DEFAULT_VALUE = "N/A";
    private final CurrencyCodesToSymbols codeToSymbols;

    public ExchangeRatesCurrencyAdapter() throws IOException {
        codeToSymbols = new FileCurrencyCodeToSymbolListLoader(getResource(), new CsvCodeAndSymbolDeserializer()).load();
    }

    private static InputStream getResource() {
        return ExchangeRatesCurrencyAdapter.class.getResourceAsStream(CURRENCY_CODE_TO_SYMBOL_CSV);
    }

    @Override
    public List<Currency> adapt(Object object) {
        return adapt(((ExchangeRatesSymbolsGetResponse) object));
    }

    private List<Currency> adapt(ExchangeRatesSymbolsGetResponse object) {
        return listOf(object.symbols());
    }

    private List<Currency> listOf(Map<String, String> symbols) {
        List<Currency> currencies = new ArrayList<>();
        for (String code : symbols.keySet()) {
            currencies.add(new Currency(code, symbols.get(code), codeToSymbols.getOrDefault(code, DEFAULT_VALUE)));
        }
        return currencies;
    }

}
