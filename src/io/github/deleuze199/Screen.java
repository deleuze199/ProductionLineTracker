package App;

/**
 * The Screen class sets and gets the screen specs.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 10/8/2019
 */
public class Screen implements ScreenSpec {
  String resolution;
  int refreshrate;
  int responsetime;

  /**
   * This is the constructor of the screen class it sets the resolution, refresh rate, and response
   * time.
   *
   * @param resolution is the product's screen resolution
   * @param refreshrate is the product's screen refresh rate
   * @param responsetime is the product's screen response time
   */
  public Screen(String resolution, int refreshrate, int responsetime) {
    this.resolution = resolution;
    this.refreshrate = refreshrate;
    this.responsetime = responsetime;
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
    return refreshrate;
  }
  /**
   * This is the getter for the screen response time.
   *
   * @return String o the screen response time
   */
  @Override
  public int getResponseTime() {
    return responsetime;
  }

  /**
   * This method returns the screen specs of the product.
   *
   * @return String of the screen's resolution, refresh rate, and response time
   */
  public String toString() {
    return "Resolution: "
        + resolution
        + "\nRefresh Rate: "
        + refreshrate
        + "\nResponse time: "
        + responsetime;
  }
}
