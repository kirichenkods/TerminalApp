package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.states.TermState;
import ru.sber.ui.UserInterface;

@AllArgsConstructor
public class ExitState implements TermState {
    UserInterface userInterface;

    /**
     * Завершает работу терминала
     * @return EXIT
     */
    @Override
    public StateType operation() {
        userInterface.showMessage("До свидания!");
        return StateType.EXIT;
    }
}
