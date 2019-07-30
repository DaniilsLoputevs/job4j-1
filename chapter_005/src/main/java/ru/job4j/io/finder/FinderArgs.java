package ru.job4j.io.finder;

import org.apache.commons.cli.*;
import ru.job4j.io.Args;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 21.07.2019
 */
public class FinderArgs {
    private Args args;


    public FinderArgs(String[] args) {
        this.args = new Args();
        this.parsingArguments(args);
    }


    public Args argsGet() {
        return args;
    }

    /**
     * Метод парсит аргументы командной строки использую библиотеку Apache Commons CLI
     * @param arg массив аргументов
     */

    public void parsingArguments(String[] arg) {
        Options options = new Options();
        options.addOption("d", true, "start path");
        options.addOption("n", true, "Name need too search");
        options.addOption("m", true, "mode");
        options.addOption("o", true, "output path ");
        options.addOption("f", false, "Find file with full equality");
        options.addOption("m", false, "find by mask");

        try {
            CommandLineParser commandLineParser = new DefaultParser();
            CommandLine cmd = commandLineParser.parse(options, arg);

            if (cmd.hasOption("d")) {
                this.args.setDir(cmd.getOptionValue("d"));
            }
            if (cmd.hasOption("n")) {
                this.args.setName(cmd.getOptionValue("n"));
            }
            if (cmd.hasOption("m")) {
                this.args.setMode(cmd.getOptionValue("m"));
            }
            if (cmd.hasOption("o")) {
                this.args.setOut(cmd.getOptionValue("o"));
            }
            if (cmd.hasOption("f")) {
                this.args.setMode("f");
            }
            if (cmd.hasOption("m")) {
                this.args.setMode("m");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
