package software.ulpgc.MoneyCalculator.api.io.currencylayer.date;

import com.google.gson.Gson;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerDateConversionGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerExchangeRateGetResponse;
import software.ulpgc.MoneyCalculator.api.io.pojos.CurrencyLayerGetResponseError;

public class CurrencyLayerDateConversionDeserializer implements DateConversionDeserializer {
    private static CurrencyLayerDateConversionGetResponse getDateConversionGetResponse(String read) {
        return new Gson().fromJson(read, CurrencyLayerDateConversionGetResponse.class);
    }

    private static CurrencyLayerGetResponseError getExchangeRateError(String read) {
        return new Gson().fromJson(read, CurrencyLayerGetResponseError.class);
    }
    
    private static boolean isSuccessful(String read) {
        return new Gson().fromJson(read, CurrencyLayerExchangeRateGetResponse.class).success();
    }

    @Override
    public Object deserialize(String read) {
        return isSuccessful(read) ? getDateConversionGetResponse(read) : getExchangeRateError(read);
    }
}
