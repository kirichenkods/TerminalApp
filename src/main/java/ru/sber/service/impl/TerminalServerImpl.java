package ru.sber.service.impl;


import ru.sber.exceptions.IncorrectMoneyInputException;
import ru.sber.exceptions.NotEnoughMoneyException;
import ru.sber.service.TerminalServer;

public class TerminalServerImpl implements TerminalServer {
    private double account;

    public TerminalServerImpl() {
        this.account = 0.0d;
    }

    public double checkAccount() {
        return account;
    }

    public void putMoney(double money) throws IncorrectMoneyInputException {
        if ((money % 100.0) != 0) {
            throw new IncorrectMoneyInputException("Сумма должна быть кратна 100!");
        }
        this.account = account + money;
    }

    public void withdrawMoney(double money) throws NotEnoughMoneyException, IncorrectMoneyInputException {
        if ((money % 100.0) != 0) {
            throw new IncorrectMoneyInputException("Сумма должна быть кратна 100!");
        }
        if (money > account) {
            throw new NotEnoughMoneyException("Недостаточно средств!");
        }
        this.account = account - money;
    }
}
