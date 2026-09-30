package software.ulpgc.MoneyCalculator.api.io.pojos;

public record CurrencyLayerGetResponseError(boolean success, Error error) {
    public record Error(int code, String info) {}
}
