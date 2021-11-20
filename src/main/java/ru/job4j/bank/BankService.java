package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает взаимодействие банка и клиента
 * @author Oleg Korneev
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение поьлзователей и счетов осуществляется в коллекции {@code HashMap}
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает пользователя и добавляет его в систему
     * @param user пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя и его аккаунт
     * и добавляет новый счет, если пользователь найден
     * @param  passport паспорт пользователя
     * @param account аккаунт пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт для поиска пользователя
     * @param passport паспорт
     * @return User пользователь с заданным паспортом
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспорт и реквизиты для поиска счета
     * @param passport паспорт для начального поиска поьлзователя
     * @param requisite реквизиты счета для поиска счета
     * @return Account счет с заданными реквизитами
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод выполняет перечисление денег с одного счёта на другой счёт
     * @param srcPassport паспорт пользователя, со счета которого будет сделан перевод
     * @param srcRequisite реквизиты пользователя, со счета которого будет сделан перевод
     * @param destPassport паспорт пользователя, которому будет сделан перевод
     * @param destRequisite реквизиты пользователя, будет сделан перевод
     * @param amount сумма перевода
     * @return boolean - результат проведения операции перевода (true - успех)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= amount) {
                src.setBalance(src.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                return true;
            }
        return false;
    }
}
