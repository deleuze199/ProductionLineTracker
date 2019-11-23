package io.github.deleuze199;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This is the ErrorController Class it is responsible for controlling the UI for all error
 * messages.
 *
 * @author Benjamin Deleuze
 * @version a.1.3 11/23/2019
 */
@SuppressWarnings("WeakerAccess")
public class ErrorController {

  @FXML private Button continueButton;

  /**
   * This is the continueButtonHandler method. It closes the error message stage when the "Continue"
   * button is clicked.
   */
  public void continueButtonHandler() {
    Stage closeStage = (Stage) continueButton.getScene().getWindow();
    closeStage.close();
  }
}
