module com.shatheesh.lsqlite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.shatheesh.lsqlite to javafx.fxml;
    exports com.shatheesh.lsqlite;
    exports com.shatheesh.lsqlite.controller;
    opens com.shatheesh.lsqlite.controller to javafx.fxml;
}