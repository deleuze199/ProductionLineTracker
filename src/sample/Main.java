package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

/**
 * This is a assembly production tracker.
 *
 * @author Benjamin Deleuze
 * @version a.1.0
 */
public class Main extends Application {

    /**
     * Start of JavaFX program.
     *
     * @param primaryStage first thing the user sees.
     * @throws Exception for any issue.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Production Line Tracker");
        primaryStage.setScene(new Scene(root, 350, 345));
        primaryStage.show();
    }

    public static void main(String[] args) {
        initializeDB();
        launch(args);
    }

    private static void initializeDB() {
        final String JDBC_DRIVER = "org.h2.Driver";
        final String DB_URL = "jdbc:h2:./res/h2";

        Statement stmt;
        //  Database credentials
        final String USER = ""; //dont public database credentials to git
        final String PASS = "";
        Connection conn; //instance of class connection set to null
        //Statement stmt = null; //instance of class Statement set to null
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //Create a connection to database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //Use the connection to create a statement
            stmt = conn.createStatement();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
