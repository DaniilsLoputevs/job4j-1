package ru.job4j.concurrency;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class PingPong extends Application {
    private static final String JOB4J = "Пинг-понг www.job4j.ru";
    public static final int X = 300;
    public static final int Y = 300;


    @Override
    public void start(Stage stage) {
        Group group = new Group();
        Rectangle rect = new Rectangle(50, 100, 10, 10);
        group.getChildren().add(rect);
        RectangleMove rectangleMove = new RectangleMove(rect);
        Thread move = new Thread(rectangleMove);
        move.start();
        stage.setScene(new Scene(group, X, Y));
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.setOnCloseRequest(windowEvent -> move.interrupt());
        stage.show();
    }



}

