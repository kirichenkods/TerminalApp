package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.service.Terminal;
import ru.sber.ui.UserInterface;
import ru.sber.strategy.TermStrategy;

@AllArgsConstructor
public class PutMoney implements TermStrategy {
    private final UserInterface userInterface;
    private final Terminal terminal;

    /**
     * Пополнение счета
     * возвращает в меню доступа к счету
     */
    @Override
    public StrategyType operation() {
        String message = "введите сумму для пополнения счета\n" +
                "Сумма должна быть кратна 100";
        userInterface.showMessage(message);
        double amount = userInterface.getAmount();
        if (amount > 0) {
            terminal.putMoney(amount);
        }
        return StrategyType.ACCESS;
    }
}