package ru.job4j.colpro;

import java.util.*;

public class Analize {
    /**
     * Метод проверяет на изменения prev список с next списоком
     *
     * @param next - предыдущее состояние списка.
     * @param next - будущее состояние списка
     * @return обьект Info .
     */
    public Info diff(List<User> prev, List<User> next) {
        Map<String, User> tmp = new HashMap<>();
        Info rs = new Info();
        for (User t : next) {
            tmp.put(t.getId(), t);
        }
        for (User p : prev) {
            User maptmp = tmp.remove(p.getId());
            if (Objects.isNull(maptmp)) {
                rs.deleted++;
            }
            if (Objects.nonNull(maptmp) && !maptmp.equals(p)) {
                rs.changed++;
            } else {
                rs.added++;
            }
        }
        return rs;
    }


    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info() {
            this.added = 0;
            this.changed = 0;
            this.deleted = 0;
        }

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{"
                    +
                    "added="
                    + added
                    +
                    ", changed="
                    + changed
                    +
                    ", deleted="
                    + deleted
                    +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    &&
                    changed == info.changed
                    &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }


}


