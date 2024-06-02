package com.shatheesh.lsqlite;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("base-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1366.0, 768.0);
        stage.setTitle("LSqlLite (alpha)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}