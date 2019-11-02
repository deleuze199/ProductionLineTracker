package io.github.deleuze199;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This is the Controller Class for the UI part of the program.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/21/2019
 */
public class Controller {
  @FXML private ComboBox<String> comboBox;
  @FXML private ChoiceBox<ItemType> choiceBox;
  @FXML private TextField productName_tf;
  @FXML private TextField manufacturer_tf;
  @FXML private TextArea productionLogTA;
  @FXML private TableView<Product> propductTable;
  @FXML private TableColumn<?, ?> IdCol;
  @FXML private TableColumn<?, ?> nameCol;
  @FXML private TableColumn<?, ?> manufacturerCol;
  @FXML private TableColumn<?, ?> typeCol;
  @FXML private ListView<Product> produceList;

  ObservableList<Product> productLine;

  /**
   * productLineButtonHandler method is a handler for when the "Add Product" button is click. This
   * method adds the product to the database.
   */
  public void productLineButtonHandler() {
    // Database driver and location
    final String Jdbc_Driver = "org.h2.Driver";
    final String db_Url = "jdbc:h2:./res/h2";
    // Database credentials
    final String user = "";
    final String pass = "";
    // instance of class connection
    Connection conn;
    try {
      // Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      // SQL String to add a product to the database
      final String insertProductLine =
          "INSERT INTO Product(type, manufacturer, name) VALUES ( ?,?,?)";
      PreparedStatement preparedstmt = conn.prepareStatement(insertProductLine);
      preparedstmt.setString(1, choiceBox.getValue().code());
      preparedstmt.setString(2, manufacturer_tf.getText());
      preparedstmt.setString(3, productName_tf.getText());
      // Execute SQL string
      preparedstmt.execute();
      // add product to productLine ArrayList
      Widget productWidget =
          new Widget(productName_tf.getText(), manufacturer_tf.getText(), choiceBox.getValue());
      productLine.add(productWidget);
      conn.close();
      preparedstmt.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * produceBtnHandler method is a handler for when the "Record Production" button is clicked. This
   * method for now just prints to the console "Produce Button".
   */
  public void produceBtnHandler() {
    int tempCount = Integer.parseInt(comboBox.getValue());
    if (tempCount != 0) {
      int itemCount = tempCount;
      for (int i = (tempCount-1); i >= 0; i--) {
        ProductionRecord produce =
            new ProductionRecord(produceList.getSelectionModel().getSelectedItem(), (itemCount - i));
        productionLogTA.appendText(produce.toString());
      }
    }
  }

  /**
   * The initialize method populates numbers 1-10 in the ComboBox and populates the ItemType enum
   * class into ChoiceBox.
   */
  public void initialize() {
    // make ObservableList display productLine Array in TableView
    productLine = FXCollections.observableArrayList();
    IdCol.setCellValueFactory(new PropertyValueFactory("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    typeCol.setCellValueFactory(new PropertyValueFactory("type"));
    propductTable.setItems(productLine);
    produceList.setItems(productLine);
    // populate ItemType enum types in the ChoiceBox
    for (ItemType cb : ItemType.values()) {
      choiceBox.getItems().add(cb);
    }
    // populate numbers 1-10 in the ComboBox
    comboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    comboBox.getSelectionModel().selectFirst();
    // makes ComboBox editable
    comboBox.setEditable(true);

    ProductionRecord pr = new ProductionRecord(38);
    productionLogTA.setText(pr.toString());
  }
}
