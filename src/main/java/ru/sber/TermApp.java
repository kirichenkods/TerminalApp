package ru.sber;

import ru.sber.factory.StrategyFactory;
import ru.sber.service.PinValidator;
import ru.sber.service.Terminal;
import ru.sber.service.TerminalServer;
import ru.sber.service.impl.PinValidatorImpl;
import ru.sber.service.impl.TerminalImpl;
import ru.sber.service.impl.TerminalServerImpl;
import ru.sber.strategy.TermContext;
import ru.sber.strategy.TermStrategy;
import ru.sber.strategy.impl.ExitStrategy;
import ru.sber.strategy.impl.MainMenuStrategy;
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
        StrategyFactory factory = new StrategyFactory(userInterface, terminal, pinValidator);
        //работа начинается с главного меню
        TermStrategy termStrategy = new MainMenuStrategy(userInterface);
        contextPattern.setTermContext(termStrategy);

        //терминал работает, пока не получит команду на выход (состояние ExitStrategy)
        while (!(contextPattern.getTermContext() instanceof ExitStrategy)) {
            TermStrategy newState = factory.create(contextPattern.operation());
            contextPattern.setTermContext(newState);
        }
    }
}
