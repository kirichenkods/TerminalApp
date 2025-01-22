package ru.sber;

import ru.sber.factory.StateFactory;
import ru.sber.service.PinValidator;
import ru.sber.service.Terminal;
import ru.sber.service.TerminalServer;
import ru.sber.service.impl.PinValidatorImpl;
import ru.sber.service.impl.TerminalImpl;
import ru.sber.service.impl.TerminalServerImpl;
import ru.sber.states.TermContext;
import ru.sber.states.TermState;
import ru.sber.states.impl.ExitState;
import ru.sber.states.impl.MainMenuState;
import ru.sber.ui.UserInterface;
import ru.sber.ui.UserInterfaceConsole;

public class TermApp {
    public static void main(String[] args) {
        String pin = "1234";
        UserInterface userInterface = new UserInterfaceConsole();
        PinValidator pinValidator = new PinValidatorImpl(userInterface, pin);
        TerminalServer terminalServer = new TerminalServerImpl();
        Terminal terminal = new TerminalImpl(terminalServer, userInterface);

        TermContext contextPattern = new TermContext();
        StateFactory factory = new StateFactory(userInterface, terminal, pinValidator);
        //работа начинается с главного меню
        TermState termState = new MainMenuState(userInterface);
        contextPattern.setContextState(termState);

        //терминал работает, пока не получит команду на выход (состояние ExitState)
        while (!(contextPattern.getContextState() instanceof ExitState)) {
            TermState newState = factory.create(contextPattern.operation());
            contextPattern.setContextState(newState);
        }
    }
}
