module tp4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens tp4 to javafx.fxml;
    exports tp4;
    exports tp4.controller;
    opens tp4.controller to javafx.fxml;
    exports tp4.model.beans;
//    opens tp4.model to javafx.fxml;
    exports tp4.model.dao;
}