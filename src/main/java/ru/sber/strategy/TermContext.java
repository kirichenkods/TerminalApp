package ru.sber.strategy;

import lombok.Getter;
import lombok.Setter;
import ru.sber.strategy.enums.StrategyType;

@Getter
@Setter
public class TermContext implements TermStrategy {
    private TermStrategy termContext;

    @Override
    public StrategyType operation() {
        return this.termContext.operation();
    }
}
