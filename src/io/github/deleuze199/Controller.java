package io.github.deleuze199;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * This is the Controller Class for the UI part of the program.
 *
 * @author Benjamin Deleuze
 * @version a.3.0 11/23/2019
 */
@SuppressWarnings({"WeakerAccess", "ConstantConditions"})
public class Controller {
  // <editor-fold desc="FXML Fields">
  @FXML private ComboBox<String> comboBox;
  @FXML private ChoiceBox<ItemType> choiceBox;
  @FXML private TextField productNameTF;
  @FXML private TextField manufacturerTF;
  @FXML private TextArea productionLogTA;
  @FXML private TableView<Product> productTable;
  @FXML private TableColumn<Product, Integer> idCol;
  @FXML private TableColumn<Product, String> nameCol;
  @FXML private TableColumn<Product, String> manufacturerCol;
  @FXML private TableColumn<Product, ItemType> typeCol;
  @FXML private ListView<Product> produceListLV;
  @FXML private TextField employeeNameTF;
  @FXML private TextField employeePasswordTF;
  @FXML private Label employeeOutputLabel;
  // </editor-fold>

  String Jdbc_Driver;
  String db_Url;
  String user;
  String pass;

  Connection conn;
  ResultSet rs;
  ObservableList<Product> productLine;
  final ArrayList<ProductionRecord> prArrayList = new ArrayList<>();

  /**
   * The productLineButtonHandler method is a handler for when the "Add Product" button is click.
   * This method inserts added product into database and calls loadProductList.
   */
  public void productLineButtonHandler() {
    String manufacturer = manufacturerTF.getText().trim();
    String productName = productNameTF.getText().trim();
    // if statements are made so error messages can appear if field(s) nt correctly filled put
    if (choiceBox.getValue() != null || !productName.equals("") || !manufacturer.equals("")) {
      if (!productName.equals("") || !manufacturer.equals("")) {
        if (choiceBox.getValue() != null || !productName.equals("")) {
          if (choiceBox.getValue() != null || !manufacturer.equals("")) {
            if (!productName.equals("")) {
              if (!manufacturer.equals("")) {
                if (choiceBox.getValue() != null) {
                  try {
                    setupDB();
                    // SQL String to add a product to the database
                    final String insertProductLine =
                        "INSERT INTO Product(type, manufacturer, name) VALUES ( ?,?,?)";
                    PreparedStatement preparedStmt = conn.prepareStatement(insertProductLine);
                    preparedStmt.setString(1, choiceBox.getValue().code());
                    preparedStmt.setString(2, manufacturer);
                    preparedStmt.setString(3, productName);
                    // Execute SQL string
                    preparedStmt.execute();
                    loadProductList();
                    conn.close();
                    preparedStmt.close();
                  } catch (SQLException e) {
                    e.printStackTrace();
                  }
                } else {
                  System.out.println("Product Line Item Type not filled out");
                  try {
                    FXMLLoader fxmlLoader =
                        new FXMLLoader(getClass().getResource("PLItemTypeError.fxml"));
                    Parent root1 = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                  } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Failed To display error");
                  }
                }
              } else {
                System.out.println("Product Line Manufacturer not filled out");
                try {
                  FXMLLoader fxmlLoader =
                      new FXMLLoader(getClass().getResource("PLManufacturerError.fxml"));
                  Parent root1 = fxmlLoader.load();
                  Stage stage = new Stage();
                  stage.setScene(new Scene(root1));
                  stage.show();
                } catch (Exception e) {
                  e.printStackTrace();
                  System.out.println("Failed To display error");
                }
              }
            } else {
              System.out.println("Product Line Product Name not filled out");
              try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PLNameError.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
              } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed To display error");
              }
            }
          } else {
            System.out.println("Product Line Product Manufacturer and Item Type not filled out");
            try {
              FXMLLoader fxmlLoader =
                  new FXMLLoader(getClass().getResource("PLManufacturerItemTypeError.fxml"));
              Parent root1 = fxmlLoader.load();
              Stage stage = new Stage();
              stage.setScene(new Scene(root1));
              stage.show();
            } catch (Exception e) {
              e.printStackTrace();
              System.out.println("Failed To display error");
            }
          }
        } else {
          System.out.println("Product Line Product Name and Item Type not filled out");
          try {
            FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("PLNameItemTypeError.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed To display error");
          }
        }
      } else {
        System.out.println("Product Line Product Name and Manufacture not filled out");
        try {
          FXMLLoader fxmlLoader =
              new FXMLLoader(getClass().getResource("PLNameManufacturerError.fxml"));
          Parent root1 = fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new Scene(root1));
          stage.show();
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Failed To display error");
        }
      }
    } else {
      System.out.println("All of Product Line fields not filled out");
      try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PLAllFieldsError.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Failed To display error");
      }
    }
  }

  /**
   * The produceBtnHandler method is a handler for when the "Record Production" button is clicked.
   * This method gets the selected product from the Product Line ListView, gets the quantity from
   * the comboBox, creates an ArrayList of ProductionRecord objects named productionRun, sends the
   * productionRun to an addToProductionDB method, calls loadProductionLog, and calls
   * showProduction.
   */
  public void recordProductionBtnHandler() {
    Product product = produceListLV.getSelectionModel().getSelectedItem();
    int itemCount = Integer.parseInt(comboBox.getValue());
    if (product != null || itemCount != 0) {
      if (product != null) {
        if (itemCount != 0) {
          ArrayList<ProductionRecord> productionRun = new ArrayList<>();
          if (itemCount != 0) {
            for (int i = (itemCount - 1); i >= 0; i--) {
              ProductionRecord pr = new ProductionRecord(product, (itemCount - i));
              productionRun.add(pr);
            }
            addToProductionDB(productionRun);
            loadProductionLog();
          }
        } else {
          System.out.println("Produce tab's Quantity invalid");
          try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource("PQuantityError.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed To display error");
          }
        }
      } else {
        System.out.println("Produce tab's Product invalid selected");
        try {
          FXMLLoader fxmlLoader =
                  new FXMLLoader(getClass().getResource("PProductError.fxml"));
          Parent root1 = fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new Scene(root1));
          stage.show();
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Failed To display error");
        }
      }
    } else {
      System.out.println("Produce tab's Product and Quantity are invalid");
      try {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("PQuantityProductError.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Failed To display error");
      }
    }
  }

  /**
   * The setupProductLineTable method associates the columns of the TableView with the fields of the
   * ObservableList.
   */
  public void setupProductLineTable() {
    productLine = FXCollections.observableArrayList();
    idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    manufacturerCol.setCellValueFactory(new PropertyValueFactory<>("manufacturer"));
    typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    productTable.setItems(productLine);
  }

  /**
   * The loadProductList method creates Product objects from the Product database table and add them
   * to the productLine ObservableList.
   */
  public void loadProductList() {
    try {
      setupDB();
      // SQL String to add a product to the database
      String sql = "SELECT * FROM PRODUCT";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      rs = preparedStmt.executeQuery();
      productLine.clear();
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
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * The loadProductionLog method creates ProductionRecord objects from the records in the
   * ProductionRecord database table, populates the productionLog ArrayList, and calls
   * showProduction.
   */
  public void loadProductionLog() {
    try {
      setupDB();
      // SQL String to add a product to the database
      String sql = "SELECT * FROM PRODUCTIONRECORD";
      PreparedStatement preparedStmt = conn.prepareStatement(sql);
      rs = preparedStmt.executeQuery();
      prArrayList.clear();
      productionLogTA.clear();
      while (rs.next()) {
        int productNum = rs.getInt("PRODUCTION_NUM");
        int productId = rs.getInt("PRODUCT_ID");
        String productSerialNum = rs.getString("SERIAL_NUM");
        Date productDate = rs.getDate("DATE_PRODUCED");
        ProductionRecord pr =
            new ProductionRecord(productNum, productId, productSerialNum, productDate);
        prArrayList.add(pr);
      }
      showProduction();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * The addToProductionDB method loops through the productionRun, inserting productionRecord object
   * information into the ProductionRecord database table.
   *
   * @param productionRun is an ArrayList of ProductionRecord objects to be inserted into the
   *     database
   */
  public void addToProductionDB(ArrayList<ProductionRecord> productionRun) {
    try {
      setupDB();
      for (ProductionRecord productionRecord : productionRun) {
        // SQL String to add a product to the database
        String sql =
            "INSERT INTO PRODUCTIONRECORD(PRODUCT_ID, SERIAL_NUM, DATE_PRODUCED) VALUES ( ?,?,?)";
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString(1, productionRecord.getProductID());
        preparedStmt.setString(2, productionRecord.getSerialNum());
        preparedStmt.setDate(3, productionRecord.getProdDate());
        // Execute SQL string
        preparedStmt.execute();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * The showProduction method populates the TextArea on the Production Log tab with the information
   * from the productionLog.
   */
  public void showProduction() {
    for (ProductionRecord productionRecord : prArrayList) {
      productionLogTA.appendText(productionRecord.toString());
    }
  }

  /**
   * The employeeCreateBtHandler method is handler to create an object of type Employee. Then sets
   * the employeeOutputLabel the the object.toString function.
   */
  public void employeeCreateBtHandler() {
    String employeeName = employeeNameTF.getText().trim();
    String employeePassword = employeePasswordTF.getText().trim();
    if (!employeeName.equals("") || !employeePassword.equals("")) {
      if (!employeeName.equals("")) {
        if (!employeePassword.equals("")) {
          Employee employee = new Employee(employeeNameTF.getText(), employeePasswordTF.getText());
          employeeOutputLabel.setText(employee.toString());
        } else {
          System.out.println("Employee's Password area not filled out");
          try {
            FXMLLoader fxmlLoader =
                    new FXMLLoader(getClass().getResource("EPasswordError.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
          } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed To display error");
          }
        }
      } else {
        System.out.println("Employee's Name area not filled out");
        try {
          FXMLLoader fxmlLoader =
                  new FXMLLoader(getClass().getResource("ENameError.fxml"));
          Parent root1 = fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new Scene(root1));
          stage.show();
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Failed To display error");
        }
      }
    } else {
      System.out.println("Employee's Name and Password are not filled out");
      try {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource("ENamePasswordError.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
      } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Failed To display error");
      }
    }
  }

  /**
   * The initialize method calls setupProductLineTable, associates the ObservableList with the
   * Product Line ListView, calls loadProductList, calls loadProductionLog, populates numbers 1-10
   * in the ComboBox, populates the ItemType enum class into ChoiceBox, populates the TableView and
   * ListView.
   */
  public void initialize() {
    setupDB();
    setupProductLineTable();
    produceListLV.setItems(productLine);
    loadProductList();
    loadProductionLog();

    // populate ItemType enum types in the ChoiceBox
    for (ItemType cb : ItemType.values()) {
      choiceBox.getItems().add(cb);
    }
    // populate numbers 1-10 in the ComboBox
    comboBox.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    // makes ComboBox editable
    comboBox.setEditable(true);
    comboBox.getSelectionModel().select(4);
  }

  /** The setupDB method sets all of the credentials needed to access the database. */
  public void setupDB() {
    Properties prop = new Properties();
    try (InputStream input = new FileInputStream("./res/properties")) {
      prop.load(input);
      // Database driver and location
      Jdbc_Driver = "org.h2.Driver";
      db_Url = "jdbc:h2:./res/h2";
      // Database credentials
      user = "";
      pass = prop.getProperty("password");
      // Register JDBC driver
      Class.forName(Jdbc_Driver);
      // Create a connection to database
      conn = DriverManager.getConnection(db_Url, user, reverseString(pass));
    } catch (IOException | ClassNotFoundException | SQLException e) {
      System.out.println("NO GO");
    }
  }

  /**
   * This method reverses the order of the password to the database.
   *
   * @param pw backward password being passed in
   * @return actual pw
   */
  public String reverseString(String pw) {
    if (pw.isEmpty()) {
      return pw;
    }
    return reverseString(pw.substring(1)) + pw.charAt(0);
  }
}
