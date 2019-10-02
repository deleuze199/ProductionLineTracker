package sample;

/**
 * ItemType is a enum that has the product type.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 9/28/2019
 */
public enum ItemType {
  AUDIO("AU"),
  VISUAL("VI"),
  AUDIO_MOBILE("AM"),
  VISUAL_MOBILE("VM");
  public String code;

  /** This is the constructor of the ItemType enum and is used to set the String code. */
  ItemType(String code) {
    this.code = code;
  }

  /**
   * This is a getter for the code string.
   *
   * @return code of the product type
   */
  public String code() {
    return code;
  }
}
