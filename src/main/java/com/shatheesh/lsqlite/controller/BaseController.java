package com.shatheesh.lsqlite.controller;

import com.shatheesh.lsqlite.db.DBUtil;
import com.shatheesh.lsqlite.db.SQLiteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BaseController {

    @FXML
    public ComboBox<String> tablesComboBox;
    @FXML
    private TextField dbPathTextField;

    List<String> tableList = new ArrayList<String>();


    @FXML
    protected void onConnectButton() {
        Connection connection = null;
        try {
            connection = SQLiteConnection.getInstance(dbPathTextField.getText()).getConnection();
            ResultSet rs =  connection.getMetaData().getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                tableList.add(rs.getString("TABLE_NAME"));
            }
            ObservableList<String> tableObservableList =  FXCollections.observableArrayList(tableList);
            tablesComboBox.setItems(tableObservableList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
//            DBUtil.DBClose(connection);
        }
    }

    @FXML
    protected void onTableSelect() {
        Connection connection = null;
        try {
            connection = SQLiteConnection.getInstance(dbPathTextField.getText()).getConnection();
            Statement statement = connection.createStatement();
            String tableSelectSql = "SELECT * FROM artists";;
            ResultSet rs = statement.executeQuery(tableSelectSql);
            while (rs.next()) {
                System.out.printf(rs.getString("Title"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
//            DBUtil.DBClose(connection);
        }
    }
}