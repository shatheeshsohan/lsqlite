package com.shatheesh.lsqlite.db;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteConnection implements Database{

    private static SQLiteConnection INSTANCE;
    private Connection conn;
    private Alert dbAlert;

    private SQLiteConnection(String url) {

        dbAlert = new Alert(Alert.AlertType.NONE);
        dbAlert.setTitle("Database Status");

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);

            dbAlert.setAlertType(Alert.AlertType.INFORMATION);
            dbAlert.setHeaderText("Connection to SQLite has been established.");
            dbAlert.show();

        } catch (Exception e) {
            dbAlert.setAlertType(Alert.AlertType.ERROR);
            dbAlert.setHeaderText("Connection to SQLite has not been established.");
            dbAlert.show();
        }

    }

    public static SQLiteConnection getInstance(String url) {
        if (INSTANCE == null) {
            INSTANCE = new SQLiteConnection(url);
        }
        return INSTANCE;
    }


    @Override
    public Connection getConnection() {
        return conn;
    }
}
