package ru.job4j.io;


import java.io.File;
import java.util.*;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 14.06.2019
 */
public class Search {


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
            if (file.isFile() && this.equalityNeed(file, exist)) {
                rs.add(file);
            }


        }
        return rs;
    }

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
            if (file.isFile() && !this.equalityNeed(file, ext1)) {
                rs.add(file);
            }
        }


        return rs;
//    }
    }


    private boolean equalityNeed(File file, List<String> exist) {
        boolean rs = false;
        String s = file.toString();
        for (String needExt : exist) {
            if (s.endsWith(needExt)) {
                rs = true;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        File file = new File(System.getProperty("java.io.tmpdir"), "folder_1");


    }

}
