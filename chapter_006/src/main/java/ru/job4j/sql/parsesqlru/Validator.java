package ru.job4j.sql.parsesqlru;

public class Validator {

    public static boolean checkTitle(String title) {
        String unvalidate = "Script";

        boolean rs = false;
        if (!title.contains(unvalidate)) {
            rs = true;

        }
        return rs;
    }
}
