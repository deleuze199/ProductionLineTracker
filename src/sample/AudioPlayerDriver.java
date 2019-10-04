package sample;

/**
 * Driver class for AudioPlayer that will test to see whether we can instantiate occurrences of it.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 10/3/2019
 */
public class AudioPlayerDriver {
  /**
   * main is where the driver class starts. It creates a object of the AudioPlayer class and use the
   * media controls.
   *
   * @param args are the command line parameters
   */
  public static void main(String[] args) {

    AudioPlayer newProduct =
        new AudioPlayer("pName", "pManufacturer", "pAudioSpecification", "pMediaType");
    System.out.println(newProduct);
    newProduct.play();
    newProduct.stop();
    newProduct.next();
    newProduct.previous();
  }
}
