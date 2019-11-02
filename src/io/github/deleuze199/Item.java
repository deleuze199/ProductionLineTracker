package io.github.deleuze199;

/**
 * The Item interface is to declare the methods used for items.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/28/2019
 */
public interface Item {
  /**
   * This is a getter for the product id.
   *
   * @return ID of the product
   */
  int getId();

  /**
   * This is a setter for the product name.
   *
   * @param name is the name of the product
   */
  void setName(String name);

  /**
   * This is a setter for the product name.
   *
   * @return name of the product
   */
  String getName();

  /**
   * This is a setter for the product manufacturer.
   *
   * @param manufacturer is the product manufacturer
   */
  void setManufacturer(String manufacturer);

  /**
   * This is a getter for the product manufacture.
   *
   * @return manufacturer of the product
   */
  String getManufacturer();
}
