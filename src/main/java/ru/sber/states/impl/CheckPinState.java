package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.service.PinValidator;
import ru.sber.states.TermState;

@AllArgsConstructor
public class CheckPinState implements TermState {
    private final PinValidator pinValidator;

    /**
     * Проверяет пин-код,
     * возвращает состояние после проверки пин-код
     *
     * @return CHECK_PIN - если пин введен неверно, но количество попыток не закончилось
     * ACCESS - если пин введен верно
     * BLOCK - терминал заблокирован на определенное время
     */
    @Override
    public StateType operation() {
        if (pinValidator.isPinCorrect()) {
            return StateType.ACCESS;
        }
        if (pinValidator.isBlock()) {
            return StateType.BLOCK;
        }
        return StateType.CHECK_PIN;
    }
}