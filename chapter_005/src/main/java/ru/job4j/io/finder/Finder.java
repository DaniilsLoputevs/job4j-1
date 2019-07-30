package ru.job4j.io.finder;

import ru.job4j.io.Search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 19.07.2019
 */
public class Finder {
    private FinderArgs finderArgs;
    List<File> rs;

    public Finder(String[] args) {
        this.finderArgs = new FinderArgs(args);
        rs = new ArrayList<>();
    }

    /**
     * Поведенческий метод который в зависимости от аргументов командной строки выполняет поиск по опреденной стратегии.
     */
    private void fillActions() {
        if (this.finderArgs.argsGet().getMode().equals("f")) {
            new SearchFullEquality().execute();
        }
        if (this.finderArgs.argsGet().getMode().equals("m")) {
            new SearchMaskEqual().execute();
        }
    }

    /**
     * Метод запускает поиск с корневого каталога используя обьект Search параметры используются из обьект FinderArgs который
     * инкапсулирует обьект Args
     * Результат работы записывается в выходной файл заданный в аргументах во время запуска.
     */
    public void startFinder() {
        this.fillActions();
        try (PrintWriter out = new PrintWriter(new FileOutputStream(this.finderArgs.argsGet().output(), false))) {
            for (File f : this.rs) {
                String s = f.getName();
                out.write(s + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Приватный внутренний лкасс имплементирующий интерфейс и выполняющий роль поиска файлов по полному совпадению имени.
     */

    private class SearchFullEquality implements ArgActions {


        public SearchFullEquality() {
        }

        @Override
        public void execute() {
            Search search = new Search();
            rs = search.filesByFullNameEquality(finderArgs.argsGet().directory(), finderArgs.argsGet().getName());


        }
    }

    /**
     * Приватный внутренний класс имплементирующий интерфейс и выполняющий роль поиска файлов по маске.
     */

    private class SearchMaskEqual implements ArgActions {

        public SearchMaskEqual() {

        }

        @Override
        public void execute() {
            Search search = new Search();
            rs = search.filesEqualityByMask(finderArgs.argsGet().directory(), finderArgs.argsGet().getName());
        }
    }


    public static void main(String[] args) {
        Finder finder = new Finder(args);
        finder.startFinder();

    }
}
