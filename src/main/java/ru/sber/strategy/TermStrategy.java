package ru.sber.strategy;

import ru.sber.strategy.enums.StrategyType;

/**
 * Применен паттерн стратегия
 */
public interface TermStrategy {
    StrategyType operation();
}
