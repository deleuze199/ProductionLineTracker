package sample;

/** The ScreenSpec interface has the methods to get the products screen specs. */
public interface ScreenSpec {
  /**
   * This is a getter for the screen resolution.
   *
   * @return String of the screen resolution
   */
  public String getResolution();

  /**
   * This is the getter for the screen refresh rate.
   *
   * @return String of the screen refresh rate
   */
  public int getRefreshRate();

  /**
   * This is the getter for the screen response time.
   *
   * @return String o the screen response time
   */
  public int getResponseTime();
}
