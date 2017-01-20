/**
  *
  * Enthält nützliche Klassen um Rechenoperatoren und Zahlen zu verbinden, um mit letzteren zu rechnen
  *
  * @version 1.0 created on 13.01.2017
  * @author Robin Freund
  */
  
import java.util.*;

class Mathematics {
  
  /**
   * Adds the given valuesto another
   *
   * @return the result
   */
  static double doAddition(double[] splittedDoubles) {
    // Integer ergebnis initialisieren und mit der ersten eingegebenen Zahl definieren
    double ergebnis = splittedDoubles[0]; 
    
    // Für jede Zahl im Array..
    for (int i = 1; i < splittedDoubles.length; i++ ) {
      if (splittedDoubles[i] != 0)  // .. prüfen ob 0..
        ergebnis += splittedDoubles[i]; // wenn nicht, addieren
      // end of if
    } // end of for
    
    return ergebnis; // ausgeben
  }
  
  
  /**
   * I won't do the same doc for each operation in this file as they're all working in the same way
   *
   * @return the result
   */
  static double doSubstraction(double[] splittedDoubles) {
    // Integer ergebnis initialisieren und mit "0" definieren
    double ergebnis = splittedDoubles[0];
    
    // Für jede Zahl im Array..
    for (int i = 1; i < splittedDoubles.length; i++ ) {
      if (splittedDoubles[i] != 0)  // .. prüfen ob 0..
        ergebnis -= splittedDoubles[i]; // wenn nicht, subtrahieren
      // end of if
    } // end of for
    
    return ergebnis; // ausgeben
  }
  
  static double doMultiplication(double[] splittedDoubles) {      
    // Integer ergebnis initialisieren und mit "0" definieren
    double ergebnis = splittedDoubles[0];
    
    // Für jede Zahl im Array..
    for (int i = 1; i < splittedDoubles.length; i++ ) {
      if (splittedDoubles[i] != 0) // .. prüfen ob 0..
        ergebnis *= splittedDoubles[i]; // wenn nicht, multiplizieren
      // end of if
    } // end of for
    
    return ergebnis; // ausgeben    
  }
  
  static double doDivision(double[] splittedDoubles) {      
    // Integer ergebnis initialisieren und mit "0" definieren
    double ergebnis = splittedDoubles[0];
    
    // Für jede Zahl im Array..
    for (int i = 1; i < splittedDoubles.length; i++ ) {
      if (splittedDoubles[i] != 0) // .. prüfen ob 0..
        ergebnis /= splittedDoubles[i]; // wenn nicht, multiplizieren
      // end of if
    } // end of for
    
    return ergebnis; // ausgeben    
  }
  
  static double doSqrt(double input) {
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = input;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.sqrt(input);
    } catch(Exception e) {
      // Würde ich hier etwas ausgeben wollen, würde es gelöscht werden bevor es der Nutzer sehen könnte
    } // end of try
    
    return ergebnis; // ausgeben
  }
  
  static double doSin(double input) {
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.sin(input);
    } catch(Exception e) {
      
    } // end of try
    
    return ergebnis; // ausgeben
  }  
  static double doCos(double input) {
    
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.cos(input);
    } catch(Exception e) {
      
    } // end of try
    
    return ergebnis; // ausgeben
  }
  static double doTan(double input) {
    
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.tan(input);
    } catch(Exception e) {
      
    } // end of try
    
    return ergebnis; // ausgeben
  }
  
  static String doAchterbahn(double input) {   
    double ergebnis = input;    
    try {
      double vorzeichen = ergebnis / Math.abs(ergebnis);
      // Definiere den Integer, in dem die Anzahl der Durchgänge festgehalten wird
      int laenge = 0;
      // Definiere die Variable, damit er nicht direkt beim Eingangswert 1 beendet
      boolean Beginning = true;     
      // Initialisiere die Liste, die alle Zwischenschritte enthält, bis der Wert 1 ausgerechnet wird      
      List<Double> steps = new ArrayList<Double>();
      
      // Füge den Startwert der Ausgabeliste hinzu                            
      steps.add( ergebnis );
      
      // Solange das Endergebnis
      while ((ergebnis != vorzeichen && ergebnis != 0 ) || Beginning) { 
        // Durchgänge um eins hochzählen
        laenge++;
        // Wir legen fest, dass das nicht mehr der Startwert ist
        Beginning = false;
        
        // Wenn ergebnis mod 2 == 0 ist, ist das Ergebnis durch zwei Teilbar (ergebnis / 2 != Kommazahl)
        if (ergebnis % 2 == 0) {
          // Rechne Ergebnis durch 2;
          ergebnis /= 2;
        } else {
          // Rechne Ergebnis mal drei plus eins
          ergebnis = (ergebnis *3) + vorzeichen;
        } // end of if-else
        
        // Füge den nächsten Wert der Liste hinzu  
        steps.add( ergebnis );
      } // end of while
      
      // Konvertiere Liste zu Array in langem, aufwendigem Prozess
      Double[] endValues = new Double[steps.size()];
      endValues = steps.toArray(endValues);   
      double[] endValuesReal = new double[endValues.length];
      
      for(int i = 0; i < endValues.length; i++)
        endValuesReal[i] = (double) endValues[i];
      
      // Endarray wird in Output-Variable gespeichert
      String output = " (Schritte)\n" + Arrays.toString(endValuesReal); // ausgeben   
      
      // Füge an die Zahlendurchgänge noch weitere Informationen
      output += "\nAnzahl der Durchgänge: " + laenge;
      output += "\nHöchste gemessene Zahl: " + Collections.max(steps);
      
      Graphics.printWhole(steps);
      
      return output;
    } catch(Exception e) {      
      return Arrays.toString(new double[0]);
    } // end of try
    
  }
}