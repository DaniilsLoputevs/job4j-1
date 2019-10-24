package ru.job4j.concurrency;

public class Dispatcher {
    public static void main(String[] args) {
        Thread a = new Thread(new Downloader("http://releases.ubuntu.com/18.04/ubuntu-18.04.3-desktop-amd64.iso", 1000));
        a.start();
    }
}
