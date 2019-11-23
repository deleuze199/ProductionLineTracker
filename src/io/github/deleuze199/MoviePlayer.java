package io.github.deleuze199;

import javafx.stage.Screen;

/**
 * The MoviePlayer class is for products what are of type visual and have multimedia controls.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 10/8/2019
 */
@SuppressWarnings("ALL")
public class MoviePlayer extends Product implements MultimediaControl {
  private final Screen screen;
  private final MonitorType monitorType;

  /**
   * This is the constructor for the MoviePlayer class.
   *
   * @param name is the name of the product
   * @param manufacturer is the manufacture of the product
   * @param screen is the screen specs of the product
   * @param monitorType is the monitor type of product
   */
  MoviePlayer(String name, String manufacturer, Screen screen, MonitorType monitorType) {
    super(name, manufacturer, ItemType.VISUAL);
    this.screen = screen;
    this.monitorType = monitorType;
  }

  /** This is to play the movie on the product. */
  @Override
  public void play() {
    System.out.println("Playing movie");
  }

  /** This is to stop the movie on the product. */
  @Override
  public void stop() {
    System.out.println("Stopping movie");
  }

  /** This is to go to the previous movie on the product. */
  @Override
  public void previous() {
    System.out.println("Previous movie");
  }

  /** This is to go to the next movie on the product. */
  @Override
  public void next() {
    System.out.println("Next movie");
  }

  /**
   * This the overridden toString method. It returns the screen and monitor of the products as a
   * String.
   *
   * @return String of base classes toString method, screen, and monitor.
   */
  @Override
  public String toString() {
    return super.toString() + "\nScreen: " + screen.toString() + "\nMonitor Type: " + monitorType;
  }
}
