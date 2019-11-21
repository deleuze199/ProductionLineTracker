package io.github.deleuze199;

/** The ScreenSpec interface has the methods to get the products screen specs. */
interface ScreenSpec {

  /**
   * This is a getter for the screen resolution.
   *
   * @return String of the screen resolution
   */
  @SuppressWarnings("unused")
  String getResolution();

  /**
   * This is the getter for the screen refresh rate.
   *
   * @return String of the screen refresh rate
   */
  @SuppressWarnings("unused")
  int getRefreshRate();

  /**
   * This is the getter for the screen response time.
   *
   * @return String o the screen response time
   */
  @SuppressWarnings("unused")
  int getResponseTime();
}
