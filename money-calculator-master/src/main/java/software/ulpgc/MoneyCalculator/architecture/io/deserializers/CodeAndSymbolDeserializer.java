package software.ulpgc.MoneyCalculator.architecture.io.deserializers;

import java.util.List;

public interface CodeAndSymbolDeserializer {
    List<String> deserialize(String line);
}
