package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.service.PinValidator;
import ru.sber.strategy.TermStrategy;

@AllArgsConstructor
public class BlockTermStrategy implements TermStrategy {
    private final PinValidator pinValidator;

    /**
     * Проверяет блокировку терминала,
     * возвращает состояние после проверки блокировки
     *
     * @return BLOCK - терминал заблокирован
     * MAIN_MENU - возврат в главное меню
     */
    @Override
    public StrategyType operation() {
        if (pinValidator.isBlock()) {
            return StrategyType.BLOCK;
        }
        return StrategyType.MAIN_MENU;
    }
}