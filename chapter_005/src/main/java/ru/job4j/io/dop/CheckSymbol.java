package ru.job4j.io.dop;


import java.util.*;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 04.08.2019
 */
public class CheckSymbol {

    /**
     * Метод проверяет два массива строк/символов на равенство через HashMap .
     *
     * @param first  - первый массив
     * @param second - второй массив
     * @return true/false
     */
    public boolean checkArrays(String[] first, String[] second) {
        boolean rs = true;
        if (first.length == second.length) {
            Map<String, String> val = new HashMap<>();
            for (String s : first) {
                val.put(s, s);
            }
            for (String check : second) {
                if (Objects.isNull(val.get(check))) {
                    rs = false;
                    break;
                }
                if (!val.get(check).equals(check)) {
                    rs = false;
                    break;
                }
            }
        } else {
            rs = false;
        }
        return rs;
    }

    /**
     * Метод проверяет идиентичность двух массивов char через HashMap
     *
     * @param f первый массив символов
     * @param s второй массив символов
     * @return true/false
     */

    public boolean checkArrays(char[] f, char[] s) {
        boolean rs = true;
        if (f.length == s.length) {
            Map<Character, Character> val = new HashMap<>();
            for (Character character : f) {
                val.put(character, character);
            }
            for (Character check : s) {
                if (Objects.isNull(val.get(check))) {
                    rs = false;
                    break;
                }
                if (!val.get(check).equals(check)) {
                    rs = false;
                    break;
                }
            }
        } else {
            rs = false;
        }


        return rs;
    }


    public static void main(String[] args) {
        CheckSymbol checkSymbol = new CheckSymbol();
        String[] f = new String[]{"a", "b", "v", "f"};
        String[] s = new String[]{"b", "v", "a", "n"};
        System.out.println(checkSymbol.checkArrays(f, s));
        char[] d = new char[]{'a', 'b', 'v', 'n'};
        char[] y = new char[]{'b', 'v', 'a', 'n'};
        System.out.println(checkSymbol.checkArrays(d, y));
    }
}
