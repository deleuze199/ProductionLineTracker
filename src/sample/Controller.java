package sample;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ComboBox comboBox;
    @FXML private ChoiceBox choiceBox;

    public void productLineButtonHandler() {

        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/h2";
        final String USER = "";
        final String PASS = "";
        Connection conn;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String insertProductLine = "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )";
            PreparedStatement preparedstmt = conn.prepareStatement(insertProductLine);
            preparedstmt.execute();
            conn.close();
            preparedstmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Product Line Button");

    }

    public void produceBtnHandler() {
        System.out.println("Produce Button");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll("Audio","Video","Other");
        comboBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        comboBox.getSelectionModel().selectFirst();
        comboBox.setEditable(true);
    }
}
