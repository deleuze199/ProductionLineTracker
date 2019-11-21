package io.github.deleuze199;

/**
 * This is the Product abstract class for each product logged into the system.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/28/2019
 */
@SuppressWarnings("unused")
public abstract class Product implements Item {
  private int id;
  private ItemType type;
  private String manufacturer;
  private String name;

  /**
   * This is a constructor for the Product class that sets the name of the product, manufacturer of
   * the product, and the type of the product.
   *
   * @param name is the name of the product
   * @param manufacturer is the manufacturer of the product
   * @param type is the type of the product
   */
  Product(int id, String name, String manufacturer, ItemType type) {
    this.id = id;
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * This is a constructor for the Product class that sets the name of the product, manufacturer of
   * the product, and the type of the product.
   *
   * @param name is the name of the product
   * @param manufacturer is the manufacturer of the product
   * @param type is the type of the product
   */
  Product(String name, String manufacturer, ItemType type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
  }

  /**
   * This is a setter for the int id.
   *
   * @param id is the id of the product
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * This is a getter for the int id.
   *
   * @return id is the product
   */
  public int getId() {
    return id;
  }

  /**
   * This is a setter for the ItemType type.
   *
   * @param type is the ItemType of the product
   */
  public void setType(ItemType type) {
    this.type = type;
  }

  /**
   * This is a getter for the Type.
   *
   * @return type of product as a String
   */
  public String getType() {
    return type.code;
  }

  /**
   * This is a setter for the String name.
   *
   * @param name is the name of the product
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This is a getter for the String name.
   *
   * @return name of the product
   */
  public String getName() {
    return name;
  }

  /**
   * This is a setter for the manufacturer.
   *
   * @param manufacturer is the manufacturer of the product
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * This is a getter for manufacturer.
   *
   * @return manufacturer of the product
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * This is a method to set and return the product information as a string.
   *
   * @return string of the product information
   */
  public String toString() {
    return "Name: " + name + " Manufacturer: " + manufacturer + " Type: " + type;
  }
}

/** Temporary class just to test Product class. */
class Widget extends Product {

  /**
   * This is a constructor for the Product class that sets the name of the product.
   *
   * @param name is the name of the product
   * @param manufacturer is the manufacturer of the product
   * @param type is the type of the product
   */
  Widget(int id, String name, String manufacturer, ItemType type) {
    super(id, name, manufacturer, type);
  }

  @SuppressWarnings("unused")
  Widget(String name, String manufacturer, ItemType type) {
    super(name, manufacturer, type);
  }
}
