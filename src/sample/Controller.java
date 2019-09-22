package sample;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

/**
 * This is the Controller Class for the UI part of the program.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/21/2019
 */
public class Controller implements Initializable {
  @FXML private ComboBox comboBox;
  @FXML private ChoiceBox choiceBox;

  /**
  * productLineButtonHandler method is a handler for when the "Add Product" button is click.
  * This method adds the product to the database.
  */
  public void productLineButtonHandler() {
    // Database driver and location
    final String Jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/h2";
    //Database credentials
    final String user = "";
    final String pass = "";
    //instance of class connection
    Connection conn;
    try {
      //Register JDBC driver
      Class.forName(Jdbc_Driver);
      //Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      //SQL String to add a product to the database
      String insertProductLine =
          "INSERT INTO Product(type, manufacturer, name) VALUES ( 'AUDIO', 'Apple', 'iPod' )";
      //Object to add SQL String as argument to PreparedStatement
      PreparedStatement preparedstmt = conn.prepareStatement(insertProductLine);
      //Execute SQL string
      preparedstmt.execute();
      conn.close();
      preparedstmt.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    System.out.println("Product Line Button");
  }

  /**
  * produceBtnHandler method is a handler for when the "Record Production" button is clicked.
  * This method for now just prints to the console "Produce Button".
  */
  public void produceBtnHandler() {
    System.out.println("Produce Button");
  }

  /**
   * The initialize method populates numbers 1-10 in the ComboBox and
   * populates "Audio","Video","Other" in the ChoiceBox.
   * @param location is the location of the database.
   * @param resources is the reference to the resources.
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //populate "Audio","Video","Other" in the ChoiceBox
    choiceBox.getItems().addAll("Audio","Video","Other");
    //populate numbers 1-10 in the ComboBox
    comboBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
    comboBox.getSelectionModel().selectFirst();
    //makes ComboBox editable
    comboBox.setEditable(true);
  }
}
