package io.github.deleuze199;

import java.sql.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
  @FXML private TextField productNameTF;
  @FXML private TextField manufacturerTF;
  @FXML private TextArea productionLogTA;
  @FXML private TableView<Product> productTable;
  @FXML private TableColumn<?, ?> idCol;
  @FXML private TableColumn<?, ?> nameCol;
  @FXML private TableColumn<?, ?> manufacturerCol;
  @FXML private TableColumn<?, ?> typeCol;
  @FXML private ListView<Product> produceList;

  // Database driver and location
  final String Jdbc_Driver = "org.h2.Driver";
  final String db_Url = "jdbc:h2:./res/h2";
  // Database credentials
  final String user = "";
  final String pass = "";
  Connection conn;
  ResultSet rs;
  ObservableList<Product> productLine;

  /**
   * productLineButtonHandler method is a handler for when the "Add Product" button is click. This
   * method adds the product to the database, TableView, and ListView.
   */
  public void productLineButtonHandler() {
    try {
      // Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      // SQL String to add a product to the database
      final String insertProductLine =
          "INSERT INTO Product(type, manufacturer, name) VALUES ( ?,?,?)";
      PreparedStatement preparedStmt = conn.prepareStatement(insertProductLine);
      preparedStmt.setString(1, choiceBox.getValue().code());
      preparedStmt.setString(2, manufacturerTF.getText());
      preparedStmt.setString(3, productNameTF.getText());
      // Execute SQL string
      preparedStmt.execute();

      loadProductList();

      // add product to productLine ObservableList
//      Widget productWidget =
//          new Widget(productNameTF.getText(), manufacturerTF.getText(), choiceBox.getValue());
//      productLine.add(productWidget);
      conn.close();
      preparedStmt.close();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * produceBtnHandler method is a handler for when the "Record Production" button is clicked. This
   * method creates objects of the ProductionRecord class.
   */
  public void produceBtnHandler() {
    Product product = produceList.getSelectionModel().getSelectedItem();
    int itemCount = Integer.parseInt(comboBox.getValue());
    ArrayList<ProductionRecord> productionRun = new ArrayList<>();
    if (itemCount != 0) {
      for (int i = (itemCount - 1); i >= 0; i--) {
        ProductionRecord pr = new ProductionRecord(product, (itemCount - i));
        productionRun.add(pr);
      }
      addToProductionDB(productionRun);
      loadProductionLog();
      showProduction();
    }
  }

  public void setupProductLineTable() {
    // make ObservableList display productLine Array in TableView
    productLine = FXCollections.observableArrayList();
    idCol.setCellValueFactory(new PropertyValueFactory("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory("manufacturer"));
    typeCol.setCellValueFactory(new PropertyValueFactory("type"));
    productTable.setItems(productLine);
  }

  public void loadProductList() {
    try {
      // Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      // SQL String to add a product to the database
      String sql = "SELECT * FROM PRODUCT";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      rs = preparedStmt.executeQuery();
      while (rs.next()) {
        String productName = rs.getString("NAME");
        String productManufacturer = rs.getString("MANUFACTURER");
        String type = rs.getString("TYPE");
        int productId = rs.getInt("ID");
        ItemType productType;
        switch (type) {
          case "AU":
            productType = ItemType.AUDIO;
            break;
          case "VI":
            productType = ItemType.VISUAL;
            break;
          case "AM":
            productType = ItemType.AUDIO_MOBILE;
            break;
          case "VM":
            productType = ItemType.VISUAL_MOBILE;
            break;
          default:
            throw new IllegalStateException("Unexpected value: " + type);
        }
        Widget product = new Widget(productId, productName, productManufacturer, productType);
        productLine.add(product);
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void loadProductionLog() {
    try {
      // Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      // SQL String to add a product to the database
      String sql = "SELECT * FROM PRODUCTIONRECORD";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      rs = preparedStmt.executeQuery();
      while (rs.next()) {
        int productNum = rs.getInt("PRODUCTION_NUM");
        int productId = rs.getInt("PRODUCT_ID");
        String productSerialNum = rs.getString("SERIAL_NUM");
        Date productDate = rs.getDate("DATE_PRODUCED");
        ProductionRecord pr = new ProductionRecord(productNum, productId, productSerialNum, productDate);
        //productionLogTA.setText(pr.toString());
        showProduction();
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  public void addToProductionDB(ArrayList<ProductionRecord> productionRun) {
    try {
      // Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, pass);
      for (int i = 0; i < productionRun.size(); i++) {
        System.out.println(productionRun.get(i).toString());
        // SQL String to add a product to the database
        String sql = "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES ( ?,?,?)";
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, productionRun.get(i).getProductID());
        preparedStmt.setString(2, productionRun.get(i).getSerialNum());
        preparedStmt.setDate(3, productionRun.get(i).getProdDate());
        // Execute SQL string
        preparedStmt.execute();
      }
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

    public void showProduction() {
      //productionLogTA.appendText(produce.toString());
    }

  /**
   * The initialize method populates numbers 1-10 in the ComboBox, populates the ItemType enum class
   * into ChoiceBox, populates the TableView and ListView.
   */
  public void initialize() {
    setupProductLineTable();
    produceList.setItems(productLine);
    loadProductList();
    loadProductionLog();

    // populate ItemType enum types in the ChoiceBox
    for (ItemType cb : ItemType.values()) {
      choiceBox.getItems().add(cb);
    }
    // populate numbers 1-10 in the ComboBox
    comboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    comboBox.getSelectionModel().selectFirst();
    // makes ComboBox editable
    comboBox.setEditable(true);

    // ProductionRecord pr = new ProductionRecord(38);
    // productionLogTA.setText(pr.toString());
  }
}
