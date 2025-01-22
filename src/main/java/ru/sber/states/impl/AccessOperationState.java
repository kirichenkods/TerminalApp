package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.exceptions.IncorrectInputException;
import ru.sber.ui.UserInterface;
import ru.sber.states.TermState;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class AccessOperationState implements TermState {
    private final UserInterface userInterface;

    /**
     * Выводит меню доступа к счету
     *
     * @return EXIT - выход
     * CHECK_ACCOUNT - проверка счета
     * WITHDRAW_MONEY - снять деньги
     * PUT_MONEY - пополнить счет
     * MAIN_MENU - если пользователь ввел неверный код
     */
    @Override
    public StateType operation() {
        String message =
                "Введите " + StateType.CHECK_ACCOUNT.getCmd() + " для проверки баланса\n" +
                        "Введите " + StateType.WITHDRAW_MONEY.getCmd() + " для снятия наличных\n" +
                        "Введите " + StateType.PUT_MONEY.getCmd() + " для пополнения счета\n" +
                        "Введите " + StateType.EXIT.getCmd() + " для выхода";
        userInterface.showMessage(message);
        String cmd = userInterface.readUserData();
        try {
            checkInputCommand(cmd, Arrays.asList(StateType.CHECK_ACCOUNT,
                    StateType.WITHDRAW_MONEY, StateType.PUT_MONEY, StateType.EXIT));
            return StateType.getCommandByValue(cmd);
        } catch (IncorrectInputException e) {
            System.err.println(e.getMessage());
        }

        return StateType.ACCESS;
    }

    private void checkInputCommand(String cmd, List<StateType> commands) throws IncorrectInputException {
        if (!commands.contains(StateType.getCommandByValue(cmd))) {
            throw new IncorrectInputException("Вводите только предложенные команды");
        }
    }
}