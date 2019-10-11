package App;

/**
 * This is the Product abstract class for each product logged into the system.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/28/2019
 */
abstract class Product implements Item {
  private int id;
  private String type;
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
  Product(String name, String manufacturer, String type) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.type = type;
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
    return "Name: " + name + "\nManufacturer: " + manufacturer + "\nType: " + type;
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
  Widget(String name, String manufacturer, String type) {
    super(name, manufacturer, type);
  }
}
