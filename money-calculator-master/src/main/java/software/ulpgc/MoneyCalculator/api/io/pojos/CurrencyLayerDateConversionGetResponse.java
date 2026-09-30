package software.ulpgc.MoneyCalculator.api.io.pojos;

public record CurrencyLayerDateConversionGetResponse(boolean success, String terms, String privacy, Query query, Info info, boolean historical, String date, double result) {
    private record Query(String from, String to, int amount) {}
    public record Info(long timestamp, double quote) {}
}
