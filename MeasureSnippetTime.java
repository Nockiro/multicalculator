 /**
  *
  * Enthält nützliche Klassen um Code-Snippets zu messen
  *
  * @version 1.0 created on 13.01.2017
  * @author Robin Freund
  */
public class MeasureSnippetTime {
  static long startTime;
  
  /**
   * Starts time measuring
   */
  public static void start() {
    // Startzeit ist die aktuelle Zeit der NanoTime-Variable
    startTime = System.nanoTime();
  }
                 
  /**
   * Stops time measuring and returns the waited time since start call
   *
   * @return the time tifference in nano seconds
   * @see start()
   */
  public static long getDiffNow() {
    // Berechne Differenz in der Zeitspanne
    return System.nanoTime() - startTime;
  }
}