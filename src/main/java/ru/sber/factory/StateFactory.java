package ru.sber.factory;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.service.PinValidator;
import ru.sber.service.Terminal;
import ru.sber.ui.UserInterface;
import ru.sber.states.*;
import ru.sber.states.impl.*;

/**
 * Реализует паттерн фабрика
 */
@AllArgsConstructor
public class StateFactory {
    private final UserInterface userInterface;
    private final Terminal terminal;
    private final PinValidator pinValidator;

    /**
     * Создает объект-состояние терминала в зависимости от переданного параметра
     * @param cmd
     * @return
     */
    public TermState create(StateType cmd) {
        TermState state = null;
        switch (cmd) {
            case EXIT -> state = new ExitState(userInterface);
            case CHECK_PIN -> state = new CheckPinState(pinValidator);
            case CHECK_ACCOUNT -> state = new CheckAccountState(terminal);
            case WITHDRAW_MONEY -> state = new WithdrawMoneyState(userInterface, terminal);
            case PUT_MONEY -> state = new PutMoney(userInterface, terminal);
            case ACCESS -> state = new AccessOperationState(userInterface);
            case BLOCK -> state = new BlockTermState(pinValidator);
            case MAIN_MENU -> state = new MainMenuState(userInterface);
        }

        return state;
    }
}