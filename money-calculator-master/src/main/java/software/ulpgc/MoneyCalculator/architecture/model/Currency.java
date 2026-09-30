package software.ulpgc.MoneyCalculator.architecture.model;

import java.util.Objects;

public class Currency {
    private final String code;
    private final String name;
    private final String symbol;

    public Currency(String code, String name, String symbol) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency money = (Currency) o;
        return Objects.equals(code, money.code) && Objects.equals(name, money.name) && Objects.equals(symbol, money.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, symbol);
    }

    @Override
    public String toString() {
        return "Money{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
