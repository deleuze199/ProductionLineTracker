package sample;

/**
 * The MultimediaControl interface is to declare the methods used for the items, on this product
 * line, basic media controls.
 *
 * @author Benjamin Deleuze
 * @version a.1.0 10/3/2019
 */
public class AudioPlayer extends Product implements MultimediaControl {
  private String audioSpecification;
  private String mediaType;

  /**
   * This is the constructor for the AudioPlayer class. It calls its base class constructor, sets
   * the audioSpecification, and mediaType.
   *
   * @param name is the name of the product
   * @param manufacturer is the manufacturer of the product
   * @param audioSpecification is the audio specifications of the product
   * @param mediaType is the media type of the product
   */
  AudioPlayer(String name, String manufacturer, String audioSpecification, String mediaType) {
    super(name, manufacturer, "AUDIO");
    this.audioSpecification = audioSpecification;
    this.mediaType = mediaType;
  }

  /**
   * This is to play the item on the product line. Normally this would have code that would instruct
   * the media player to play, but this will simply display a message.
   */
  @Override
  public void play() {
    System.out.println("Playing");
  }

  /**
   * This is to stop the item on the product line. Normally this would have code that would instruct
   * the media player to stop, but this will simply display a message.
   */
  @Override
  public void stop() {
    System.out.println("Stopping");
  }

  /**
   * This is to get the previous item on the product line. Normally this would have code that would
   * instruct the media player to go to the previous, but this will simply display a message.
   */
  @Override
  public void previous() {
    System.out.println("Previous");
  }

  /**
   * This is to get the next item on the product line. Normally this would have code that would
   * instruct the media player to go to the next, but this will simply display a message.
   */
  @Override
  public void next() {
    System.out.println("Next");
  }

  /**
   * This is a method to set and return the product information as a string.
   *
   * @return String with the products information
   */
  public String toString() {
    return super.toString()
        + "\nSupported Audio Formats: "
        + audioSpecification
        + "\nSupported Playlist Formats: "
        + mediaType;
  }
}
