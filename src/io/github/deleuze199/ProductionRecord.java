package io.github.deleuze199;

import java.sql.Date;

/** ProductRecord class is made to print the product information to the Production Log tab. */
@SuppressWarnings("ALL")
class ProductionRecord {

  // The recorded product's specifications.
  private int productionNumber;
  private int productID;
  private String serialNumber;
  private java.sql.Date dateProduced;

  /**
   * Constructor for the ProductionRecord and sets the fields of the class.
   *
   * @param productID correspond to the productID from the Product table
   */
  ProductionRecord(int productID) {
    this.productID = productID;
    productionNumber = 0;
    serialNumber = "0";
    dateProduced = new java.sql.Date(System.currentTimeMillis());
  }

  /**
   * Overloaded constructor for the ProductionRecord and sets the fields of the class.
   *
   * @param productID correspond to the productID from the Product table
   */
  ProductionRecord(
      int productionNumber, int productID, String serialNumber, java.sql.Date dateProduced) {
    this.productionNumber = productionNumber;
    this.productID = productID;
    this.serialNumber = serialNumber;
    this.dateProduced = dateProduced;
  }

  /**
   * This is a overloaded constructor for the ProductionRecord class and takes in a Product object
   * and and int itemCount.
   *
   * @param pr is the object of the Product class
   * @param itemCount is the integer of how many items are being produced
   */
  ProductionRecord(Product pr, int itemCount) {
    String serialNum =
        pr.getManufacturer().substring(0, 3) + pr.getType() + String.format("%05d", itemCount);
    setSerialNum(serialNum);
    dateProduced = new java.sql.Date(System.currentTimeMillis());
    setProdDate(dateProduced);
    setProductID(pr.getId());
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
        + dateProduced
        + "\n";
  }

  /**
   * This is a setter for the productionNumber field.
   *
   * @param productionNumber is the production number
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
   * @param productID is the product ID
   */
  @SuppressWarnings("WeakerAccess")
  public void setProductID(int productID) {
    this.productID = productID;
  }

  /**
   * This is the getter for the productID field.
   *
   * @return productID
   */
  String getProductID() {
    return String.valueOf(productID);
  }

  /**
   * This is a setter for the serialNumber field.
   *
   * @param serialNumber is the product serial number
   */
  private void setSerialNum(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * This is the getter for the serialNumber field.
   *
   * @return serialNumber
   */
  String getSerialNum() {
    return serialNumber;
  }

  /**
   * This is a setter for the dateProduced field.
   *
   * @param dateProduced is the products date produced
   */
  @SuppressWarnings("WeakerAccess")
  public void setProdDate(Date dateProduced) {
    this.dateProduced = dateProduced;
  }

  /**
   * This is the getter for the dateProduced field.
   *
   * @return dateProduced
   */
  java.sql.Date getProdDate() {
    return dateProduced;
  }
}
