package software.ulpgc.MoneyCalculator.architecture.io.loaders;

import software.ulpgc.MoneyCalculator.architecture.io.CurrencyCodesToSymbols;

import java.io.IOException;

public interface CurrencyCodesToSymbolsLoader {
    CurrencyCodesToSymbols load() throws IOException;
}
