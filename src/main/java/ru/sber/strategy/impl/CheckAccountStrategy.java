package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.service.Terminal;
import ru.sber.strategy.TermStrategy;

@AllArgsConstructor
public class CheckAccountStrategy implements TermStrategy {
    private final Terminal terminal;

    /**
     * Сообщает пользователю состояние счета
     * возвращает состояние меню доступа к счету
     *
     * @return Commands.ACCESS
     */
    @Override
    public StrategyType operation() {
        terminal.checkAccount();

        return StrategyType.ACCESS;
    }
}