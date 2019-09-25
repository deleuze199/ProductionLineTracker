package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is a assembly production tracker.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/21/2019
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

  /** This method initializes the database and connects to it. */
  private static void initializeDB() {
    final String Jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/h2";
    Statement stmt;
    // Database credentials
    final String user = ""; // dont public database credentials to git
    final String pass = "";
    Connection conn; // instance of class connection
    try {
      // STEP 1: Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      // Use the connection to create a statement
      stmt = conn.createStatement();
      stmt.close();
      conn.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }
}
