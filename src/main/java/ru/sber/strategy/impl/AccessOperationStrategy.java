package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.exceptions.IncorrectInputException;
import ru.sber.ui.UserInterface;
import ru.sber.strategy.TermStrategy;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class AccessOperationStrategy implements TermStrategy {
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
    public StrategyType operation() {
        String message =
                "Введите " + StrategyType.CHECK_ACCOUNT.getCmd() + " для проверки баланса\n" +
                        "Введите " + StrategyType.WITHDRAW_MONEY.getCmd() + " для снятия наличных\n" +
                        "Введите " + StrategyType.PUT_MONEY.getCmd() + " для пополнения счета\n" +
                        "Введите " + StrategyType.EXIT.getCmd() + " для выхода";
        userInterface.showMessage(message);
        String cmd = userInterface.readUserData();
        try {
            checkInputCommand(cmd, Arrays.asList(StrategyType.CHECK_ACCOUNT,
                    StrategyType.WITHDRAW_MONEY, StrategyType.PUT_MONEY, StrategyType.EXIT));
            return StrategyType.getCommandByValue(cmd);
        } catch (IncorrectInputException e) {
            System.err.println(e.getMessage());
        }

        return StrategyType.ACCESS;
    }

    private void checkInputCommand(String cmd, List<StrategyType> commands) throws IncorrectInputException {
        if (!commands.contains(StrategyType.getCommandByValue(cmd))) {
            throw new IncorrectInputException("Вводите только предложенные команды");
        }
    }
}