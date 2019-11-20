package io.github.deleuze199;

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
    Parent root = FXMLLoader.load(getClass().getResource("NewPLT.fxml"));
    primaryStage.setTitle("Production Line Tracker");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();
  }

  /**
   * This is where the program begins.
   *
   * @param args are the command line parameters
   */
  public static void main(String[] args) {
    launch(args);
  }
}
