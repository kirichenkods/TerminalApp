package ru.sber.service;

public interface PinValidator {
    /**
     * Проверка введенного пароля
     * @return
     */
    boolean isPinCorrect();

    /**
     * Проверяет заблокирован ли терминал
     * @return
     */
    boolean isBlock();
}
