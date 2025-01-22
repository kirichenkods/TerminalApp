package ru.sber.states.impl;

import lombok.AllArgsConstructor;
import ru.sber.states.enums.StateType;
import ru.sber.exceptions.IncorrectInputException;
import ru.sber.ui.UserInterface;
import ru.sber.states.TermState;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class MainMenuState implements TermState {
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
    public StateType operation() {
        String welcomeMessage =
                "Для ввода пин-кода введите " + StateType.CHECK_PIN.getCmd() + "\n" +
                        "Для выхода введите " + StateType.EXIT.getCmd();
        userInterface.showMessage(welcomeMessage);

        //получение команды от пользователя
        String cmd = userInterface.readUserData();
        try {
            checkInputCommand(cmd, Arrays.asList(StateType.CHECK_PIN, StateType.EXIT));
            return StateType.getCommandByValue(cmd);
        } catch (IncorrectInputException e) {
            System.err.println(e.getMessage());
        }
        return StateType.MAIN_MENU;
    }

    private void checkInputCommand(String cmd, List<StateType> commands) throws IncorrectInputException {
        if (!commands.contains(StateType.getCommandByValue(cmd))) {
            throw new IncorrectInputException("Вводите только предложенные команды");
        }
    }
}