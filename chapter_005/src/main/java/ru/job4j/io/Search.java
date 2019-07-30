package ru.job4j.io;


import java.io.File;
import java.util.*;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 14.06.2019
 */
public class Search {

    /**
     * Метод для поиска из parent пути включая exist
     *
     * @param parent корень с которого требуется начать поиск
     * @param exist  расширение которое требуется добавить .
     * @return List обьектов File найденных в результате работы метода.
     */
    public List<File> files(String parent, List<String> exist) {
        List<File> rs = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                for (File deep : file.listFiles()) {
                    queue.offer(deep);
                }
            }
            if (file.isFile() && this.equalityExtension(file, exist)) {
                rs.add(file);
            }


        }
        return rs;
    }

    /**
     * Метод поиска файлов содержащих имя или часть имени .
     *
     * @param parent корень с которого требуется начать поиск
     * @param name   имя или часть имени для которые требуется добавить
     * @return List обьектов File найденных в результате работы метода.
     */

    public List<File> filesByFullNameEquality(String parent, String name) {
        List<File> rs = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                for (File deep : file.listFiles()) {
                    queue.offer(deep);

                }
            }
            if (file.isFile() && this.equalityByFullStringName(file, name)) {
                rs.add(file);
            }


        }
        return rs;
    }

    /**
     * Метод поиска файлов содержащих часть иимени.
     *
     * @param parent - корень с которого начинается поиск
     * @param name   - часть имени которое требуется добавить.
     * @return List обьектов File найденных в результате работы метода.
     */
    public List<File> filesEqualityByMask(String parent, String name) {
        List<File> rs = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                for (File deep : file.listFiles()) {
                    queue.offer(deep);
                }
            }
            if (file.isFile() && this.equalityByMaskName(file, name)) {
                rs.add(file);
            }


        }
        return rs;
    }


    /**
     * Метод для поиска из parent пути исключая расширения
     *
     * @param parent корень с которого требуется начать поиск
     * @param ext    расширения которые требуется исключить.
     * @return List обьектов File найденных в результате работы метода.
     */
    public List<File> filesWithFold(String parent, String ext) {
        List<String> ext1 = List.of(ext);
        List<File> rs = new LinkedList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(new File(parent));
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                rs.add(file);
                for (File deep : file.listFiles()) {
                    queue.offer(deep);
                }
            }
            if (file.isFile() && !this.equalityExtension(file, ext1)) {
                rs.add(file);
            }
        }


        return rs;
//    }
    }

    /**
     * Метод проверяет файл на расширение.
     *
     * @param file  файл
     * @param exist расщирение
     * @return true/false
     */
    private boolean equalityExtension(File file, List<String> exist) {
        boolean rs = false;
        String s = file.toString();
        for (String needExt : exist) {
            if (s.endsWith(needExt)) {
                rs = true;
            }
        }
        return rs;
    }

    /**
     * Метод проверяет что файл содержит имя требуемое для поиска.
     *
     * @param file файл
     * @param need требуемое имя или часть имени
     * @return true/false
     */
    private boolean equalityByFullStringName(File file, String need) {
        boolean rs = false;
        if (file.getName().equals(need)) {
            rs = true;

        }
        return rs;

    }

    private boolean equalityByMaskName(File file, String need) {
        boolean rs = false;
        if (file.getName().contains(need)) {
            rs = true;

        }
        return rs;

    }

    public static void main(String[] args) {
        File file = new File(System.getProperty("java.io.tmpdir"), "folder_1");


    }

}
