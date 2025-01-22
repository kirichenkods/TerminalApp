package ru.sber.states;

import lombok.Getter;
import lombok.Setter;
import ru.sber.states.enums.StateType;

@Getter
@Setter
public class TermContext implements TermState {
    private TermState contextState;

    @Override
    public StateType operation() {
        return this.contextState.operation();
    }
}
