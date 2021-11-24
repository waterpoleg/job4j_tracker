package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход паспорт и реквизиты для поиска счета
     * @param passport паспорт для начального поиска поьлзователя
     * @param requisite реквизиты счета для поиска счета
     * @return Account счет с заданными реквизитами
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> ac = Optional.empty();
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            ac = accounts.stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        }
        return ac;
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= amount) {
                src.get().setBalance(src.get().getBalance() - amount);
                dest.get().setBalance(dest.get().getBalance() + amount);
                return true;
            }
        return false;
    }
}
