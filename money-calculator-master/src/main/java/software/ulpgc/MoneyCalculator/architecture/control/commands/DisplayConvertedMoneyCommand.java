package software.ulpgc.MoneyCalculator.architecture.control.commands;

import software.ulpgc.MoneyCalculator.architecture.model.Money;
import software.ulpgc.MoneyCalculator.architecture.view.MoneyDisplay;

public class DisplayConvertedMoneyCommand implements Command {

    private final MoneyDisplay display;
    private final Money convertedMoney;

    public DisplayConvertedMoneyCommand(MoneyDisplay display, Money newMoney) {
        this.display = display;
        this.convertedMoney = newMoney;
    }

    @Override
    public void execute() {
        display.display(convertedMoney);
    }
}
