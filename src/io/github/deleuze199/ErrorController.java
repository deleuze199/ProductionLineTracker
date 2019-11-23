package io.github.deleuze199;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ErrorController {

  @FXML private Button continueButton;

  public void continueButtonHandler() {
    Stage closeStage = (Stage) continueButton.getScene().getWindow();
    closeStage.close();
  }
}
