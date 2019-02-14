package ru.job4j.bank;

import java.util.*;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 11.02.2019
 */
public class Bank {


    private Map<User, ArrayList<Account>> map = new HashMap<>();

    /**
     * Добавление пользователя с проверкой при помощи метода putIfAbsent
     * пробрасывает исключение  "Пользователь уже добавлен"
     *
     * @param user - новый пользователь.
     */
    public void addUser(User user) {
        if (this.map.putIfAbsent(user, new ArrayList<>()) != null) {
            throw new UserExeptions("Пользователь уже существует.");
        }
    }

    /**
     * Метод по поиску пользователя
     *
     * @param passport - паспорт пользователя.
     * @return - Найденный результат или исключение .
     */
    public User findUser(String passport) {
        User find = null;
        for (User user : this.map.keySet()) {
            if (passport.equals(user.getPassport())) {
                find = user;
                break;

            }
        }
        return find;
    }

    /**
     * Метод по удалению пользователя.
     *
     * @param o входящий пользователь для удаления.
     */
    public void deleteUser(User o) {
        map.remove(o);
    }

    /**
     * Метод добавляет аккаунт пользователю.
     *
     * @param passport - паспорт пользователя.
     * @param account  - счёт.
     */
    public void addAccountToUser(String passport, Account account) {
        ArrayList<Account> t = this.map.get(findUser(passport));
        if (!Objects.isNull(t)) {
            if (!t.contains(account)) {
                t.add(account);
            }
        }
    }

    /**
     * Метод по поиску счетов пользователя.
     *
     * @param passport - паспорт.
     * @return - List<Account> найденных счетов.
     */

    public List<Account> findAccountsUser(String passport) {
        User u = findUser(passport);
        List<Account> a = null;
        if (!Objects.isNull(u)) {
            a = map.get(u);
        }

        return a;
    }

    /**
     * Метод по поиску счёта пользователя.
     *
     * @param passport   - паспорт пользователя.
     * @param requisites - реквизиты счёта.
     * @return - найденный счёт.
     */
    public Account getOneAccount(String passport, String requisites) {
        List<Account> temp = findAccountsUser(passport);
        Account account = null;
        if (!Objects.isNull(temp)) {
            for (Account ac : temp) {
                if (ac.getRequisites().equals(requisites)) {
                    account = ac;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод по удалению аккаунта у пользователя.
     *
     * @param passport - паспорт пользователя.
     * @param account  - удаляемый элемент.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUser(passport);
        if (!Objects.isNull(user)) {
            List<Account> accounts = map.get(user);
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getRequisites().equals(account.getRequisites())) {
                    accounts.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * Метод по трансферу средств между счетами.
     *
     * @param srcPassport  - паспорт исходящего пользователя.
     * @param srcRequisite - реквизиты исходящего счёта.
     * @param destPassport - паспорт получателя.
     * @param dstRequisite - реквизиты счёта назначения.
     * @param amount       - сумма
     * @return - boolean переменная о возможности перевода false/true.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean possible = false;
        Account srcAccount = getOneAccount(srcPassport, srcRequisite);
        Account destAccount = getOneAccount(destPassport, dstRequisite);
        if (!Objects.isNull(srcAccount) && !Objects.isNull(destAccount)) {
            if (srcAccount.getValue() >= amount) {
                srcAccount.subValueinAccount(amount);
                destAccount.addValueinAccount(amount);
                possible = true;
            }
        }
        return possible;
    }


    @Override
    public String toString() {
        return "Bank{"
                +
                "map="
                + map
                +
                '}';
    }
}
