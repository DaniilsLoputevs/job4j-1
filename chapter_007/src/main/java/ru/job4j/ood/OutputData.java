package ru.job4j.ood;

import java.io.PrintWriter;


public class OutputData {

    public void printMenu(UserMenu userMenu) {
        do {
            try (PrintWriter bf = new PrintWriter(System.out)) {
                for (String value : userMenu.getActions()) {
                    bf.write(value + System.lineSeparator());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (userMenu.isWork());
    }

    public static void main(String[] args) {
        UserMenu userMenu = new UserMenu();
        OutputData outputData = new OutputData();
        outputData.printMenu(userMenu);
    }
}
