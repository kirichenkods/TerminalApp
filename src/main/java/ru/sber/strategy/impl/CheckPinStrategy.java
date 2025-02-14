package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.service.PinValidator;
import ru.sber.strategy.TermStrategy;

@AllArgsConstructor
public class CheckPinStrategy implements TermStrategy {
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
    public StrategyType operation() {
        if (pinValidator.isPinCorrect()) {
            return StrategyType.ACCESS;
        }
        if (pinValidator.isBlock()) {
            return StrategyType.BLOCK;
        }
        return StrategyType.CHECK_PIN;
    }
}