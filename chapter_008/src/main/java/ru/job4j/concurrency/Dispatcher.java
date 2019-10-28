package ru.job4j.concurrency;


public class Dispatcher {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        String url = "http://releases.ubuntu.com/18.04/ubuntu-18.04.3-desktop-amd64.iso";
        Downloader downloader = new Downloader(url, 512);
        Thread a = new Thread(downloader);
        a.start();
    }
}
