package ru.sber.states;

import ru.sber.states.enums.StateType;

/**
 * Применен паттерн состояние
 */
public interface TermState {
    StateType operation();
}
