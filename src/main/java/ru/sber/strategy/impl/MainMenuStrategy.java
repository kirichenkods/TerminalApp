package ru.sber.strategy.impl;

import lombok.AllArgsConstructor;
import ru.sber.strategy.enums.StrategyType;
import ru.sber.exceptions.IncorrectInputException;
import ru.sber.ui.UserInterface;
import ru.sber.strategy.TermStrategy;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class MainMenuStrategy implements TermStrategy {
    private final UserInterface userInterface;

    /**
     * Главное меню
     * возвращает
     *
     * @return EXIT - выход
     * GET_PIN - получение пин-кода
     * MAIN_MENU если пользователь вводит неправильный код
     */
    @Override
    public StrategyType operation() {
        String welcomeMessage =
                "Для ввода пин-кода введите " + StrategyType.CHECK_PIN.getCmd() + "\n" +
                        "Для выхода введите " + StrategyType.EXIT.getCmd();
        userInterface.showMessage(welcomeMessage);

        //получение команды от пользователя
        String cmd = userInterface.readUserData();
        try {
            checkInputCommand(cmd, Arrays.asList(StrategyType.CHECK_PIN, StrategyType.EXIT));
            return StrategyType.getCommandByValue(cmd);
        } catch (IncorrectInputException e) {
            System.err.println(e.getMessage());
        }
        return StrategyType.MAIN_MENU;
    }

    private void checkInputCommand(String cmd, List<StrategyType> commands) throws IncorrectInputException {
        if (!commands.contains(StrategyType.getCommandByValue(cmd))) {
            throw new IncorrectInputException("Вводите только предложенные команды");
        }
    }
}