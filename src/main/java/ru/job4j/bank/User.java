package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описыает модель пользователя
 * @author Oleg Korneev
 * @version 1.0
 */
public class User {
    /**
     * Класс содержит поля {@code String passoprt} и {@code String username}
     * описывающие номера пасппорта пользователя и его имя
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер паспорта пользователя
     * @return passport номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод принимает номер паспорта пользователя и записывает его в модель
     * @param passport паспорт пользователя.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя пользователя
     * @return имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод принимает имя пользователя и записывает его в модель
     * @param username паспорт пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
