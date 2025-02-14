package ru.sber.strategy.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Список состояний терминала
 */
@AllArgsConstructor
@Getter
public enum StrategyType {
    EXIT("0"), //выход
    CHECK_PIN("1"), //проверка пин-кода
    CHECK_ACCOUNT("2"), //проверка счета
    WITHDRAW_MONEY("3"), //снять деньги
    PUT_MONEY("4"),  //пополнить счет
    ACCESS("5"), //доступ к операциям
    BLOCK("6"), //доступ заблокирован
    MAIN_MENU("7"); //главное меню

    private final String cmd;

    /**
     * По переданному значению возвращает соответствующую команду
     */
    public static StrategyType getCommandByValue(String command) {
        StrategyType[] commands = StrategyType.values();
        for (StrategyType cmd : commands) {
            if (cmd.getCmd().equals(command)) {
                return cmd;
            }
        }
        // если не удалось получить команду, то выход в главное меню
        return MAIN_MENU;
    }
}
