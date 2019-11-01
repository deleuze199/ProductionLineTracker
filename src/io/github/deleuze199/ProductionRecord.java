package io.github.deleuze199;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.Date;

/** ProductRecord class is made to print the product information to the Production Log tab */
public class ProductionRecord {

  // @FXML private TextArea productionLogTA;

  int productionNumber;
  int productID;
  String serialNumber;
  Date dateProduced;

  /**
   * Constructor for the ProductionRecord and sets the fields of the class.
   *
   * @param productID correspond to the productID from the Product table
   */
  ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new Date();
  }
  /**
   * Overloaded constructor for the ProductionRecord and sets the fields of the class.
   *
   * @param productID correspond to the productID from the Product table
   */
  ProductionRecord(int productionNumber, int productID, String serialNumber, Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  ProductionRecord(Product pr, int count) {
    String serialNum = pr.getManufacturer().substring(0, 3) + pr.getType();
    setSerialNum(serialNum);
    dateProduced = new Date();
    // still need to make auto-incrementing number
  }

  /**
   * This is a method to set and return the production information as a string.
   *
   * @return string of the product information
   */
  @Override
  public String toString() {
    return "Prod. Num: "
        + productionNumber
        + " Product ID: "
        + productID
        + " Serial Num: "
        + serialNumber
        + " Date: "
        + dateProduced;
  }

  /**
   * This is a setter for the productionNumber field.
   *
   * @param productionNumber
   */
  public void setProductionNum(int productionNumber) {
    this.productionNumber = productionNumber;
  }

  /**
   * This is the getter for the productionNumber field.
   *
   * @return productionNumber
   */
  public int getProductionNum() {
    return productionNumber;
  }
  /**
   * This is a setter for the productID field.
   *
   * @param productID
   */
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * This is the getter for the productID field.
   *
   * @return productID
   */
  public int getProductID() {
    return productID;
  }

  /**
   * This is a setter for the serialNumber field.
   *
   * @param serialNumber
   */
  public void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This is the getter for the serialNumber field.
   *
   * @return serialNumber
   */
  public String getSerialNum() {
    return serialNumber;
  }

  /**
   * This is a setter for the dateProduced field.
   *
   * @param dateProduced
   */
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * This is the getter for the dateProduced field.
   *
   * @return dateProduced
   */
  public Date getProdDate() {
    return dateProduced;
  }
}
