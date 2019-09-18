package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Benjamin Deleuze
 * @brief
 */
public class Main extends Application {
  /**
   * Start of JavaFX program
   *
   * @param primaryStage first thing the user sees
   * @throws Exception
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 350, 300));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
