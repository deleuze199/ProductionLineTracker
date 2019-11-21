package io.github.deleuze199;

/**
 * The MultimediaControl interface is to declare the methods used for the items, on this product
 * line, basic media controls.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 10/3/2019
 */
interface MultimediaControl {
  /** This is to play the item on the product line. */
  @SuppressWarnings("unused")
  void play();

  /** This is to stop the item on the product line. */
  @SuppressWarnings("unused")
  void stop();

  /** This is to get the previous item on the product line. */
  @SuppressWarnings("unused")
  void previous();

  /** This is to get the next item on the product line. */
  @SuppressWarnings("unused")
  void next();
}
