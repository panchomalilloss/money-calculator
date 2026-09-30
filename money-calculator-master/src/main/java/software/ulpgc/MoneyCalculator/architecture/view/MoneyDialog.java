package software.ulpgc.MoneyCalculator.architecture.view;

import software.ulpgc.MoneyCalculator.architecture.model.Money;

public interface MoneyDialog {
    Money getMoney();
    void setMoney(Money money);
    boolean isEmpty();
}
