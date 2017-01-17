  /**
  *
  * Enthält nützliche Klassen um mit Konsolen und Rechenmethoden sinnvoll zu arbeiten
  *
  * @version 1.0 created on 13.01.2017
  * @author Robin Freund
  */
  
import java.util.*;

public class Utils {

  /**
   * Creates a (for a console) beautified string - means: =========, new line, text, again =======
   *
   * @return the beautified string
   */
  public static String makeBeauty(String s) {
    // Definiere Endstring
    String output = "";
    
    // Zähle Zeichenanzahl im String, der gedruckt werden soll - oder maximale Zeilenlänge
    int charCount = s.length() > 79 ? 79 : s.length();
    // Legt erst ein neues Zeichenarray mit der Anzahl der "=" als Größe an und füllt dann alle Nullstellen mit einem "="
    output += new String(new char[charCount]).replace("\0", "=") + "\n";
    // Fügt eigentliche Ausgabe + eine neue Zeile an
    output += s + "\n";
    // Legt erst ein neues Zeichenarray mit der Anzahl der "=" als Größe an und füllt dann alle Nullstellen mit einem "="
    output += new String(new char[charCount]).replace("\0", "=") ;
    
    return output; // Gibt den String so zurück
  }
  /**
   * Generates random doubles in the given range and given amount
   *
   * @param start Determines the start of range to be generated   
   * @param end Determines the end of range to be generated     
   * @param amount Determines the number of values to be generated
   * @return the array of random generated values
   */
  public static double[] generateRandom(int start, int end, int amount) {
    Random random = new Random();
    double[] randomArray = new double[amount];
    
    for (int i = 0; i < amount; i++)      
      // Fülle i-te Stelle mit beliebigem Int im Bereich auf
      randomArray[i] = random.nextInt(end - start + 1) + start;  
    
    return randomArray;
  }
  
  public static double[] tauscheItem(double[] splittedDoubles, int firstInd, int secInd) {
    double temp   = splittedDoubles[firstInd];
    splittedDoubles[firstInd]   = splittedDoubles[secInd];
    splittedDoubles[secInd] = temp;  
    return splittedDoubles;
  }
}