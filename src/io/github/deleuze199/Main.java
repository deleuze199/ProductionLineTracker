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
   */
  @Override
  public void start(Stage primaryStage) {
    try {
      Parent root = FXMLLoader.load(getClass().getResource("NewPLT.fxml"));
      primaryStage.setTitle("Production Line Tracker");
      primaryStage.setScene(new Scene(root, 600, 400));
      primaryStage.show();
    } catch (Exception e) {
      System.out.println("Program Failed To Load.");
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FailedError.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
      } catch (Exception ex) {
        System.out.println("Failed To display error");
      }
    }
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
