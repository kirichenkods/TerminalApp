package ru.sber.service;

public interface PinValidator {
    /**
     * Проверка введенного пароля
     */
    boolean isPinCorrect();

    /**
     * Проверяет заблокирован ли терминал
     */
    boolean isBlock();
}
