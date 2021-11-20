package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет
 * @author Oleg Korneev
 * @version 1.0
 */
public class Account {
    /**
     * Поля класса {@code String requisite} и {@code double balance}
     * описывают реквизиты аккаунта и баланс счета
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Методы вовзращает реквизиты счета
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод принимает на вход реквизиты и записывает их в модель
     * @param requisite реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метода позволяет получить баланс счета
     * @return balance баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод принимает на вход баланс и устанавливает его в модель
     * @param balance значение баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
