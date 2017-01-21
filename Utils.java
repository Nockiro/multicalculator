  /**
  *
  * Enth�lt n�tzliche Klassen um mit Konsolen und Rechenmethoden sinnvoll zu arbeiten
  *
  * @version 1.0 created on 13.01.2017
  * @author Robin Freund
  */
  
import java.util.*;

public class Utils {

  /**
   * Creates a (for a console) beautified string - means: =========, new line, text, again =======  (as much as given in paramter)
   *
   * @return the beautified string
   */
  public static String makeBeauty(String s, int count) {
    // Definiere Endstring
    String output = "";
    
    // Z�hle Zeichenanzahl im String, der gedruckt werden soll - oder maximale Zeilenl�nge
    int charCount = count;
    // Legt erst ein neues Zeichenarray mit der Anzahl der "=" als Gr��e an und f�llt dann alle Nullstellen mit einem "="
    output += new String(new char[charCount]).replace("\0", "=") + "\n";
    // F�gt eigentliche Ausgabe + eine neue Zeile an
    output += s + "\n";
    // Legt erst ein neues Zeichenarray mit der Anzahl der "=" als Gr��e an und f�llt dann alle Nullstellen mit einem "="
    output += new String(new char[charCount]).replace("\0", "=") ;
    
    return output; // Gibt den String so zur�ck
  }
  
  /**
   * Method overload: Creates as many ==== as the string requires
   *
   * @return the beautified string
   */
  public static String makeBeauty(String s) {
    return makeBeauty(s, s.length() > Calc.consoleWidth ? Calc.consoleWidth - 1: s.length());
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
      // F�lle i-te Stelle mit beliebigem Int im Bereich auf
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