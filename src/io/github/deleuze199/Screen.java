package io.github.deleuze199;

/**
 * The Screen class sets and gets the screen specs.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 10/8/2019
 */
@SuppressWarnings("unused")
public class Screen implements ScreenSpec {
  private final String resolution;
  private final int refreshRate;
  private final int responseTime;

  /**
   * This is the constructor of the screen class it sets the resolution, refresh rate, and response
   * time.
   *
   * @param resolution is the product's screen resolution
   * @param refreshRate is the product's screen refresh rate
   * @param responseTime is the product's screen response time
   */
  public Screen(String resolution, int refreshRate, int responseTime) {
    this.resolution = resolution;
    this.refreshRate = refreshRate;
    this.responseTime = responseTime;
  }

  /**
   * This is a getter for the screen resolution.
   *
   * @return String of the screen resolution
   */
  @Override
  public String getResolution() {
    return resolution;
  }

  /**
   * This is the getter for the screen refresh rate.
   *
   * @return String of the screen refresh rate
   */
  @Override
  public int getRefreshRate() {
    return refreshRate;
  }

  /**
   * This is the getter for the screen response time.
   *
   * @return String o the screen response time
   */
  @Override
  public int getResponseTime() {
    return responseTime;
  }

  /**
   * This returns the resolution and refresh rate of the screens product.
   *
   * @return String of the screen's resolution, refresh rate, and response time
   */
  @Override
  public String toString() {
    return "Resolution: "
        + resolution
        + "\nRefresh Rate: "
        + refreshRate
        + "\nResponse Time: "
        + responseTime;
  }
}
