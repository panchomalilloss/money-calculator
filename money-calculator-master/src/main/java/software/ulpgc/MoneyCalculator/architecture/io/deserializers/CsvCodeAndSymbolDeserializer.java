package software.ulpgc.MoneyCalculator.architecture.io.deserializers;

import java.util.List;

public class CsvCodeAndSymbolDeserializer implements CodeAndSymbolDeserializer {
    @Override
    public List<String> deserialize(String line) {
        return deserialize(line.split(","));
    }

    private List<String> deserialize(String[] fields) {
        return List.of(fields[0], fields[1]);
    }
}