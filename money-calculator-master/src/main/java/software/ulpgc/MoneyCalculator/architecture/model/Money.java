package software.ulpgc.MoneyCalculator.architecture.model;

public record Money(double amount, Currency currency) {

    public static Money getFrom(double amount, Currency currency) {
        return new Money(amount, currency);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
