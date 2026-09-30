package software.ulpgc.MoneyCalculator.architecture.io.loaders;

import software.ulpgc.MoneyCalculator.architecture.io.CurrencyCodesToSymbols;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.CodeAndSymbolDeserializer;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileCurrencyCodeToSymbolListLoader implements CurrencyCodesToSymbolsLoader {
    public static final int CODE = 0;
    public static final int SYMBOL = 1;
    private final CodeAndSymbolDeserializer deserializer;
    private final InputStream fileAsInputStream;

    public FileCurrencyCodeToSymbolListLoader(InputStream fileAsInputStream, CodeAndSymbolDeserializer deserializer) {
        this.fileAsInputStream = fileAsInputStream;
        this.deserializer = deserializer;
    }

    @Override
    public CurrencyCodesToSymbols load() throws IOException {
        return new CurrencyCodesToSymbols(getCurrencyCodeToSymbolMap());
    }

    private Map<String, String> getCurrencyCodeToSymbolMap() throws IOException {
        Map<String, String> codesToSymbols = new HashMap<>();
        try (BufferedReader reader = getBufferedReader()) {
            reader.readLine();
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                codesToSymbols.put(getKey(deserializer.deserialize(line)), getValue(deserializer.deserialize(line)));
            }
        }
        return codesToSymbols;
    }

    private String getValue(List<String> codeAndSymbol) {
        return codeAndSymbol.get(SYMBOL);
    }

    private String getKey(List<String> codeAndSymbol) {
        return codeAndSymbol.get(CODE);
    }

    private BufferedReader getBufferedReader() throws IOException {
        return new BufferedReader(new InputStreamReader(this.fileAsInputStream));
    }
}
