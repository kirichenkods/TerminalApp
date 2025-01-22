package ru.sber.service;

public interface Terminal {
    /**
     * проверка баланса
     */
    void checkAccount();

    /**
     * Снять наличные
     * @param money
     */
    void withdrawMoney(double money);

    /**
     * Пополнить счет
     * @param money
     */
    void putMoney(double money);
}
