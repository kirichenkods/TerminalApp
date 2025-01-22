package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.service.Terminal;
import ru.sber.states.TermState;

@AllArgsConstructor
public class CheckAccountState implements TermState {
    private final Terminal terminal;

    /**
     * Сообщает пользователю состояние счета
     * возвращает состояние меню доступа к счету
     *
     * @return Commands.ACCESS
     */
    @Override
    public StateType operation() {
        terminal.checkAccount();

        return StateType.ACCESS;
    }
}