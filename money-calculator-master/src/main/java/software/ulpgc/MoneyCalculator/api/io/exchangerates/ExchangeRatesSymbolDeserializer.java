package software.ulpgc.MoneyCalculator.api.io.exchangerates;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.ExchangeRatesSymbolsGetResponse;

public class ExchangeRatesSymbolDeserializer implements SymbolDeserializer {
    @Override
    public Object deserialize(String read) {
        return new Gson().fromJson(read, ExchangeRatesSymbolsGetResponse.class);
    }
}
