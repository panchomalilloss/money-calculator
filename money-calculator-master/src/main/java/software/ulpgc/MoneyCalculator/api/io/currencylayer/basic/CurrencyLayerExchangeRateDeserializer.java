package software.ulpgc.MoneyCalculator.api.io.currencylayer.basic;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerGetResponseError;
import software.ulpgc.MoneyCalculator.architecture.io.deserializers.ExchangeRateDeserializer;

public class CurrencyLayerExchangeRateDeserializer implements ExchangeRateDeserializer {
    private static CurrencyLayerExchangeRateGetResponse getExchangeRateGetResponse(String read) {
        return new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class);
    }

    private static CurrencyLayerGetResponseError getExchangeRateError(String read) {
        return new Gson().fromJson(read, CurrencyLayerGetResponseError.class);
    }


    private static boolean isSuccessful(String read) {
        return new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class).success();
    }

    @Override
    public Object deserialize(String read) {
        return isSuccessful(read) ? getExchangeRateGetResponse(read) : getExchangeRateError(read);
    }
}
