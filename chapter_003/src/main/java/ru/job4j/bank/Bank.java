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
     * @param user - новый пользователь.
     * @return true\false добавление пользователя в структуру.
     */
    public boolean addUser(User user) {
        boolean rs = false;
        if (this.map.putIfAbsent(user, new ArrayList<>()) == null) {
            rs = true;

        }
        return rs;
    }

    /**
     * Метод по поиску пользователя
     *
     * @param passport - паспорт пользователя.
     * @return - Найденный результат или исключение .
     */
    public User findUser(String passport) {
        User find = this.map.keySet().stream().filter(user -> user.getPassport().equals(passport)).findAny().orElse(null);
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
        User rs = findUser(passport);
        if (!Objects.isNull(rs)) {
            ArrayList<Account> t = this.map.get(rs);
            if (!t.contains(account)) {
                t.add(account);
            }
        }
    }

    /**
     * Метод по поиску счетов пользователя.
     *
     * @param passport - паспорт.
     * @return - List найденных счетов.
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
        Account finded = null;
        List<Account> temp = findAccountsUser(passport);
        finded = temp.stream().filter(account -> account.getRequisites().equals(requisites)).findAny().orElse(null);
        return finded;
    }

    /**
     * Метод по удалению аккаунта у пользователя.
     *
     * @param passport - паспорт пользователя.
     * @param account  - удаляемый элемент.
     * @return true\false результат удаления аккаунта у пользователя.
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
        boolean rs = false;
        ArrayList<Account> finded = this.map.get(findUser(passport));
        if (!Objects.isNull(finded)) {
            finded.removeIf(account1 -> account.equals(account1));
            rs = true;
        }
        return rs;
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
