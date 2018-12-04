package ru.job4j.search.generic;
import java.util.HashMap;
import java.util.List;

/**
 * Package for Collections lite
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 04.12.2018
 */

public class UserConvert {
    /**
     * Метод конвертирует List User в HashMap.
     *
     * @param list - Список User.
     * @return HashMap .
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User u : list) {
            result.put(u.getId(), u);
        }
        return result;
    }
}
