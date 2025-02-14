package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.strategy.TermStrategy;
import ru.sber.ui.UserInterface;

@AllArgsConstructor
public class ExitStrategy implements TermStrategy {
    UserInterface userInterface;

    /**
     * Завершает работу терминала
     * @return EXIT
     */
    @Override
    public StrategyType operation() {
        userInterface.showMessage("До свидания!");
        return StrategyType.EXIT;
    }
}
