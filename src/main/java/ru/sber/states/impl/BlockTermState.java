package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.service.PinValidator;
import ru.sber.states.TermState;

@AllArgsConstructor
public class BlockTermState implements TermState {
    private final PinValidator pinValidator;

    /**
     * Проверяет блокировку терминала,
     * возвращает состояние после проверки блокировки
     *
     * @return BLOCK - терминал заблокирован
     * MAIN_MENU - возврат в главное меню
     */
    @Override
    public StateType operation() {
        if (pinValidator.isBlock()) {
            return StateType.BLOCK;
        }
        return StateType.MAIN_MENU;
    }
}