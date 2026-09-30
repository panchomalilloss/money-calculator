package software.ulpgc.MoneyCalculator.architecture.view;

import software.ulpgc.MoneyCalculator.architecture.model.Money;

public interface MoneyDisplay {
    void display(Money money);
    Money getMoney();
    boolean isEmpty();
}
