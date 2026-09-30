package software.ulpgc.MoneyCalculator.architecture.io.adapters;

import software.ulpgc.MoneyCalculator.architecture.model.Currency;

import java.util.List;

public interface CurrencyAdapter {
    List<Currency> adapt(Object object);
}
