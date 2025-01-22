package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.service.Terminal;
import ru.sber.ui.UserInterface;
import ru.sber.states.TermState;

@AllArgsConstructor
public class PutMoney implements TermState {
    private final UserInterface userInterface;
    private final Terminal terminal;

    /**
     * Пополнение счета
     * возвращает в меню доступа к счету
     */
    @Override
    public StateType operation() {
        String message = "введите сумму для пополнения счета\n" +
                "Сумма должна быть кратна 100";
        userInterface.showMessage(message);
        double amount = userInterface.getAmount();
        if (amount > 0) {
            terminal.putMoney(amount);
        }
        return StateType.ACCESS;
    }
}