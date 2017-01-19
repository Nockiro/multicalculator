/**
  *
  * Dient zur Verbindung mehrerer Zahlen durch Rechenoperatoren
  *
  * @version 1.1 vom 06.10.2016
  * @author Robin Freund
  */
import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class Calc {
  
  // Variablendeklaration
  public static Scanner sc = new Scanner(System.in);
  public static double LastCalc = 0;
  public static double[] LastCalcArray;
  
  public static void main(String[] args) {
    printCases(); // "Hilfe" ausgeben und "Programm starten"
  } // end of main
  
  // printCases: Gibt nacheinander die Möglichkeiten auf, das Programm zu benutzen
  private static void printCases() {
    System.out.println("-----Taschenrechner-----\nEs gibt fünf Möglichkeiten, mit Zahlen zu rechnen:\n-------");  
    System.out.println("(A)ddition");  
    System.out.println("(S)ubtraktion");  
    System.out.println("(M)ultiplikation");  
    System.out.println("(D)ivision"); 
    System.out.println("(W)urzel");
    System.out.println("(Sin)us");  
    System.out.println("(Cos)inus"); 
    System.out.println("(Tan)gens");   
    System.out.println("(B)ubbleSort"); 
    System.out.println("-------");
    
    System.out.print("Ihre Wahl? ");
    checkCase(); // Rechenart abfragen und ausführen, führt am Ende wieder zum Anfang von printCases()        
  }
  
  private static void checkCase() {
    String output = "";
    
    // prüft die Eingabe nach Befehlen und mache alle Buchstaben zu Kleinbuchstaben 
    // --> Erspart, nach großen und kleinen Buchstaben in der Eingabe zu scannen
    // und filtert sog. "Whitespace"-Zeichen, also Leerzeichen etc. aus der Eingabe
    switch (sc.nextLine().toLowerCase().trim()) {
      case "exit":
        return;
      case "debug":
        output = Utils.printBeauty("Letztes Ergebnis: " + LastCalc);
        break;
      case "a": 
        System.out.print("Eingabe (Zu addierende Zahlen mit + trennen): ");
        LastCalc = doAddition();
        break;
      case "s":       
        System.out.print("Eingabe (Zu subtrahierende Zahlen mit - trennen): ");
        LastCalc = doSubstraction();
        break;
      case "m":  
        System.out.print("Eingabe (Zahlen durch x oder * trennen): ");
        LastCalc = doMultiplication();
        break;
      case "d":  
        System.out.print("Eingabe (Zahlen durch / oder : trennen): ");
        LastCalc = doDivision();
        break; 
      case "w":  
        System.out.print("Eingabe: ");
        LastCalc = doSqrt();
        break;
      case "sin":
        System.out.print("Eingabe: ");   
        LastCalc = doSin();
        break;
      case "cos":
        System.out.print("Eingabe: "); 
        LastCalc = doCos();
        break;
      case "tan":
        System.out.print("Eingabe: ");  
        LastCalc = doTan();   
        break;    
      case "b":
        System.out.print("Eingabe (Zahlen durch / trennen):");  
        LastCalcArray = doBubbleSort();
        break;
      default:
        output = Utils.printBeauty("! Fehler: Ungültige Eingabe bzw. nicht erkanntes Kommando !");
    } // end of switch
    
    
    // Wenn es einen Output gibt, gib ihn auas
    if (output.equals("")) 
    {
      // Wenn eine Zahlenliste definiert ist, gibt die statt dem letzten Ergebnis aus
      if (LastCalcArray != null) {
        output = Utils.printBeauty("Ergebnis: " + Arrays.toString(LastCalcArray));
        LastCalcArray = null;
      } else {
        output = Utils.printBeauty("Ergebnis: " + LastCalc);
      }
    } // end of if
    
    // Direkte Verbindung zum Input/Output-Kanal der Konsole und den Clear-Befehl per Hand ausführen
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch(Exception e) {
      
    } // end of try
    
    // Ergebnis der letzten Rechnung drucken    
    System.out.println(output);
    
    // Wenn die Rechnung durchgeführt wurde, erneut fragen
    printCases();
  }
  
  private static double[] DifferentNumbers(String splitChar) {
    // Variablendeklaration
    String input;
    String[] splittedInput;
    double[] splittedDoubles;
    
    // Lese den Input der Zahlen, im Idealfall getrennt durch das Trennzeichen ein und bereinige ihn von Leerzeichen
    input = sc.nextLine().trim();
    
    // Wenn es kein Trennzeichen gibt, ..
    if (splitChar.equals("")) 
      splittedInput = new String[] {input}; // .. fülle die Eingabeliste nur mit der kompletten Eingabe, ungetrennt, ansonsten.. 
    else       
      splittedInput = input.split(splitChar);  // .. teile die Zahlen mit dem Trennzeichen auf
    // end of if-else
    
    // Definiere ein neues Integer-Array mit der Größe, die der Anzahl der getrennten Zahlen entspricht
    splittedDoubles = new double[splittedInput.length];
    
    // Gehe für jede Zahl im Eingangsarray durch, ob sie ein Integer ist und speichere sie im IntArray
    for (int i = 0; i < splittedInput.length; i++) {
      try {
        
        // Wenn "ans" als "Zahl" eingegeben wird, ..
        if (splittedInput[i].equals("ans"))
          splittedDoubles[i] = LastCalc; // .. stattdessen das letzte Ergebnis auswählen, ansonsten ..
        else 
          splittedDoubles[i] = Double.parseDouble(splittedInput[i]);   // .. String in Double, also eine Gleitkommazahl, umwandeln
        
      } catch(Exception e) { // Fange Fehler bei der Umwandlung der Zahl ab
        // ignored      - Der Wert an der Stelle i bliebe null, von daher kann man den Fehlerfall ignorieren, wenn er später abgefangen wird
      } // end of try
    } // end of for
    
    return splittedDoubles; 
  }
  
  private static double doAddition() {
    // Erst die verschiedenen Zahlen aus der Eingabe, getrennt durch "+" holen..
    double[] splittedDoubles = DifferentNumbers("\\+");
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
  private static double doSubstraction() {
    // Erst die verschiedenen Zahlen aus der Eingabe, getrennt durch "-" holen..
    double[] splittedDoubles = DifferentNumbers("\\-");
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
  
  private static double doMultiplication() {      
    // Erst die verschiedenen Zahlen aus der Eingabe, getrennt durch "*" oder "x" holen..
    double[] splittedDoubles = DifferentNumbers("(\\*|x)");
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
  
  private static double doDivision() {      
    // Erst die verschiedenen Zahlen aus der Eingabe, getrennt durch "/" oder ":" holen..
    double[] splittedDoubles = DifferentNumbers("(\\/|:)");
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
  
  private static double doSqrt() {
    
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.sqrt(DifferentNumbers("")[0]);
    } catch(Exception e) {
      // Würde ich hier etwas ausgeben wollen, würde es gelöscht werden bevor es der Nutzer sehen könnte
    } // end of try
    
    return ergebnis; // ausgeben
  }
  
  private static double doSin() {
    
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.sin(DifferentNumbers("")[0]);
    } catch(Exception e) {
      
    } // end of try
    
    return ergebnis; // ausgeben
  }  
  private static double doCos() {
    
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.cos(DifferentNumbers("")[0]);
    } catch(Exception e) {
      
    } // end of try
    
    return ergebnis; // ausgeben
  }
  private static double doTan() {
    
    // Initialisiere die Endvariable und definiere sie mit "0"
    double ergebnis = 0;
    
    try {
      // Wurzel aus der eingegebenen Zahl ziehen
      ergebnis = Math.tan(DifferentNumbers("")[0]);
    } catch(Exception e) {
      
    } // end of try
    
    return ergebnis; // ausgeben
  }
  
  ///// SORTIERALGORITHMEN
  private static double[] doBubbleSort() {
                      
    // Erst die verschiedenen Zahlen aus der Eingabe, getrennt durch "/" oder ":" holen..
    double[] splittedDoubles = DifferentNumbers("(\\/|:)");
    
    // Variablen initialisieren
    boolean unsortiert = true;
    double temp;
    
    while (unsortiert){
      unsortiert = false;
      for (int i=0; i < splittedDoubles.length-1; i++) 
        if (splittedDoubles[i] > splittedDoubles[i+1]) {                      
          temp   = splittedDoubles[i];
          splittedDoubles[i]   = splittedDoubles[i+1];
          splittedDoubles[i+1] = temp;
          unsortiert = true;
        }          
    } 
    return splittedDoubles;
  }
} // end of class Calc

class Utils {

  // Ohne die Angabe, wieviele "=" später gedruckt werden sollen, Standardanzahl verwenden: Soviele wie Zeichen
  public static String printBeauty(String s) {
    // Definiere Endstring
    String output = "";
    
    // Zähle Zeichenanzahl im String, der gedruckt werden soll..
    int charCount = s.length();
    // Legt erst ein neues Zeichenarray mit der Anzahl der "=" als Größe an und füllt dann alle Nullstellen mit einem "="
    output += new String(new char[charCount]).replace("\0", "=") + "\n";
    // Fügt eigentliche Ausgabe + eine neue Zeile an
    output += s + "\n";
    // Legt erst ein neues Zeichenarray mit der Anzahl der "=" als Größe an und füllt dann alle Nullstellen mit einem "="
    output += new String(new char[charCount]).replace("\0", "=") ;
    
    return output; // Gibt den String so zurück
  }
}
