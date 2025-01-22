package ru.sber.service.impl;

import lombok.AllArgsConstructor;
import ru.sber.exceptions.IncorrectMoneyInputException;
import ru.sber.exceptions.NotEnoughMoneyException;
import ru.sber.service.Terminal;
import ru.sber.service.TerminalServer;
import ru.sber.ui.UserInterface;

@AllArgsConstructor
public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final UserInterface userInterface;

    @Override
    public void checkAccount() {
        userInterface.showMessage("баланс равен " + server.checkAccount() + "\n");
    }

    @Override
    public void withdrawMoney(double money) {
        try {
            server.withdrawMoney(money);
        } catch (NotEnoughMoneyException | IncorrectMoneyInputException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void putMoney(double money) {
        try {
            server.putMoney(money);
        } catch (IncorrectMoneyInputException e) {
            System.err.println(e.getMessage());
        }
    }
}
