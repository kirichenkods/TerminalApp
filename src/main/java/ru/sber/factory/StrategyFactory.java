package ru.sber.factory;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.service.PinValidator;
import ru.sber.service.Terminal;
import ru.sber.ui.UserInterface;
import ru.sber.strategy.*;
import ru.sber.strategy.impl.*;

/**
 * Реализует паттерн фабрика
 */
@RequiredArgsConstructor
public class StrategyFactory {
    private final UserInterface userInterface;
    private final Terminal terminal;
    private final PinValidator pinValidator;

    /**
     * Создает объект-состояние терминала в зависимости от переданного параметра
     * @param cmd
     * @return
     */
    public TermStrategy create(StrategyType cmd) {
        TermStrategy state = null;
        switch (cmd) {
            case EXIT -> state = new ExitStrategy(userInterface);
            case CHECK_PIN -> state = new CheckPinStrategy(pinValidator);
            case CHECK_ACCOUNT -> state = new CheckAccountStrategy(terminal);
            case WITHDRAW_MONEY -> state = new WithdrawMoneyStrategy(userInterface, terminal);
            case PUT_MONEY -> state = new PutMoney(userInterface, terminal);
            case ACCESS -> state = new AccessOperationStrategy(userInterface);
            case BLOCK -> state = new BlockTermStrategy(pinValidator);
            case MAIN_MENU -> state = new MainMenuStrategy(userInterface);
        }

        return state;
    }
}