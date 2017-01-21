/**
  *
  * [old: Dient zur Verbindung mehrerer Zahlen durch Rechenoperatoren (old: october 2016)] 
  *
  * Dient zur Verwendung von Zahlen in jeder Hinsicht
  * Diese Klasse enthält alle Methoden zur Interaktion mit der Konsole
  * 
  * @version 1.3 vom 20.01.2017
  * @author Robin Freund            
  */
import java.io.IOException;
import java.util.*;

public class Calc {
  
  // Variablendeklaration
  public static Scanner sc = new Scanner(System.in);
  public static double LastCalc = 0;
  public static double LastTimeDiff = 0;
  public static double[] LastCalcArray;
  public static String LastCalcString;       
  static int consoleWidth = 150;

         
  /**
   * Main program // Hauptprogramm
   */
  public static void main(String[] args) {
    try {      
      //set Windows (!!) Terminal width 100, height 30
      new ProcessBuilder("cmd", "/c", "mode " + consoleWidth + "").inheritIO().start().waitFor();
    } catch(Exception e) {
      
    } 
    
    printCases(); // "Hilfe" ausgeben und "Programm starten"
  } // end of main
  
  /**
   * Gibt nacheinander die Möglichkeiten aus, das Programm zu benutzen
   */
  private static void printCases() {
    System.out.println(Utils.makeBeauty("------Taschenrechner------\nEs gibt acht Möglichkeiten, mit Zahlen zu rechnen:", consoleWidth - 1));  
    System.out.println("> (A)ddition");  
    System.out.println("> (S)ubtraktion");  
    System.out.println("> (M)ultiplikation");  
    System.out.println("> (D)ivision"); 
    System.out.println("> (W)urzel");
    System.out.println("> (Sin)us");  
    System.out.println("> (Cos)inus"); 
    System.out.println("> (Tan)gens");      
    System.out.println("> (Ach[was])terbahnzahlen");  
    System.out.println("-------\nSortieralgorithmen \nBeispiel: B für Bubblesort, B-Z für Zufallszahlengenerator:\n-------");  
    System.out.println("> (B)ubblesort");     
    System.out.println("+> mit (-Z)ufallszahlen, die sortiert werden");  
    System.out.println("> (I)nsertSort");     
    System.out.println("+> mit (-Z)ufallszahlen, die sortiert werden");    
    System.out.println("> (Qu)ickSort");     
    System.out.println("+> mit (-Z)ufallszahlen, die sortiert werden");
    System.out.println("> (Se)lectionsort");     
    System.out.println("+> mit (-Z)ufallszahlen, die sortiert werden"); 
    System.out.println("-------");          
    System.out.println("> (E)xit um das Programm zu beenden"); 
    
    System.out.print("\nIhre Wahl? ");
    checkCase(); // Rechenart abfragen und ausführen, führt am Ende wieder zum Anfang von printCases()        
  }
  
  /**
   * This function checks the user input for a decision which function call has to be made
   */
  private static void checkCase() {
    String output = "";
    
    // TODO: MAKE FUNCTIONS INVOKABLE FOR MORE EFFICIENT TIME MEASURING
    
    // prüft die Eingabe nach Befehlen und mache alle Buchstaben zu Kleinbuchstaben 
    // --> Erspart, nach großen und kleinen Buchstaben in der Eingabe zu scannen
    // und filtert sog. "Whitespace"-Zeichen, also Leerzeichen etc. aus der Eingabe
    switch (sc.nextLine().toLowerCase().trim()) {
      case "exit":
      case "q":
      case "e":
      case "x":
        return;
      case "debug":
        output = Utils.makeBeauty("Letztes Ergebnis: " + LastCalc);
        break;
      case "a": 
        System.out.print("Eingabe (Zu addierende Zahlen mit + trennen): ");
        LastCalc = Mathematics.doAddition(getDifferentNumbers("(\\+)"));
        break;
      case "s":       
        System.out.print("Eingabe (Zu subtrahierende Zahlen mit - trennen): ");  
        LastCalc = Mathematics.doSubstraction(getDifferentNumbers("\\-"));
        break;
      case "m":  
        System.out.print("Eingabe (Zahlen durch x oder * trennen): ");
        LastCalc = Mathematics.doMultiplication(getDifferentNumbers("(\\*|x)"));
        break;
      case "d":  
        System.out.print("Eingabe (Zahlen durch / oder : trennen): ");
        LastCalc = Mathematics.doDivision(getDifferentNumbers("(\\/|:)"));
        break; 
      case "w":  
        System.out.print("Eingabe des Wertes: ");
        LastCalc = Mathematics.doSqrt(getDifferentNumbers("")[0]); 
        break;
      case "sin":
        System.out.print("Eingabe des Wertes: ");   
        LastCalc = Mathematics.doSin(getDifferentNumbers("")[0]); 
        break;
      case "cos":
        System.out.print("Eingabe des Wertes: "); 
        LastCalc = Mathematics.doCos(getDifferentNumbers("")[0]); 
        break;
      case "tan":            
        System.out.print("Eingabe des Wertes: ");         
        // Hole den User-Input und übergebe ihn an den Tan-Rechner
        LastCalc = Mathematics.doTan(getDifferentNumbers("")[0]);   
        break;          
      case "ach":
      case "achwas":
        System.out.print("Eingabe des Wertes: ");  
        LastCalcString = Mathematics.doAchterbahn(getDifferentNumbers("")[0]);   
        break;    
      case "b":
        System.out.print("Eingabe (Zahlen durch / trennen):"); 
        double[] inputArray = getDifferentNumbers("(\\/)");      
        // Starte die Stoppuhr
        MeasureSnippetTime.start();
        LastCalcArray = Sortings.doBubbleSort(inputArray);      
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern
        LastTimeDiff = MeasureSnippetTime.getDiffNow();   
        break;  
      case "i": 
        System.out.print("Eingabe (Zahlen durch / trennen):");   
        inputArray = getDifferentNumbers("(\\/)");      
        // Starte die Stoppuhr
        MeasureSnippetTime.start();
        LastCalcArray = Sortings.doInsertSort(inputArray);      
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern
        LastTimeDiff = MeasureSnippetTime.getDiffNow();   
        break;              
      case "se": 
        System.out.print("Eingabe (Zahlen durch / trennen):");  
        inputArray = getDifferentNumbers("(\\/)");            
        // Starte die Stoppuhr
        MeasureSnippetTime.start();
        LastCalcArray = Sortings.doSelectionSort(inputArray);  
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern
        LastTimeDiff = MeasureSnippetTime.getDiffNow();   
        break;  
      case "qu":
        System.out.print("Eingabe (Zahlen durch / trennen):");  
        inputArray = getDifferentNumbers("(\\/)");            
        // Starte die Stoppuhr
        MeasureSnippetTime.start();
        LastCalcArray = Sortings.doQuickSort(inputArray, 0, inputArray.length - 1);  
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern
        LastTimeDiff = MeasureSnippetTime.getDiffNow();   
        break;  
      case "b-z":
        // Gib Random
        double[] randomArray = printRandomner();
        // Starte die Stoppuhr
        MeasureSnippetTime.start();
        // Sortieralgorithmus aufrufen und in Ausgabearray speichern
        LastCalcArray = Sortings.doBubbleSort(randomArray);  
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern
        LastTimeDiff = MeasureSnippetTime.getDiffNow();      
        break;  
      case "i-z":
        // Gib Random
        randomArray = printRandomner();
        // Starte die Stoppuhr
        MeasureSnippetTime.start();               
        // Sortieralgorithmus aufrufen und in Ausgabearray speichern
        LastCalcArray = Sortings.doInsertSort(randomArray);
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern  
        LastTimeDiff = MeasureSnippetTime.getDiffNow();      
        break;            
      case "se-z":
        // Gib Random (und starte die "Stoppuhr")
        randomArray = printRandomner();
        // Starte die Stoppuhr
        MeasureSnippetTime.start();               
        // Sortieralgorithmus aufrufen und in Ausgabearray speichern
        LastCalcArray = Sortings.doSelectionSort(randomArray);
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern  
        LastTimeDiff = MeasureSnippetTime.getDiffNow();      
        break;      
      case "qu-z":
        // Gib Random (und starte die "Stoppuhr")
        randomArray = printRandomner();
        // Starte die Stoppuhr
        MeasureSnippetTime.start();               
        // Sortieralgorithmus aufrufen und in Ausgabearray speichern
        LastCalcArray = Sortings.doQuickSort(randomArray, 0, randomArray.length - 1);  
        // Zeitdifferenz ausrechnen und in Ausgabevariable speichern  
        LastTimeDiff = MeasureSnippetTime.getDiffNow();      
        break;   
      case "daniel":
        output = "Jup. Die Belohnung liegt im Waschbecken";
        break;   
      default:
        output = Utils.makeBeauty("! Fehler: Ungültige Eingabe bzw. nicht erkanntes Kommando !");
    } // end of switch
    
    
    // Wenn es einen Output gibt, gib ihn auas
    if (output.equals("")) 
    {
      // Wenn eine Zahlenliste definiert ist, gibt die statt dem letzten Ergebnis aus
      if (LastCalcArray != null) {
        output = Utils.makeBeauty("Ergebnis: " + Arrays.toString(LastCalcArray));
        LastCalcArray = null;
      } else if (LastCalcString != null) {
        output = Utils.makeBeauty("Ergebnis: " + LastCalcString);
        LastCalcString = null;
      } else {
        // end of if-else
        output = Utils.makeBeauty("Ergebnis: " + LastCalc);
      }
    } // end of if
    
    // Direkte Verbindung zum Input/Output-Kanal der Konsole und den Clear-Befehl per Hand ausführen
    try {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    } catch(Exception e) {
      
    } // end of try
    
    // Ergebnis der letzten Rechnung drucken    
    System.out.println(output);
    if (output == "Jup.")
      return;
    
    // Ergebnis des letzten Benchmarks drucken
    if (LastTimeDiff != 0) {
      System.out.println(Utils.makeBeauty("Laufzeit: " + (LastTimeDiff / 1000000) + " ms"));
      // Reset
      LastTimeDiff = 0;
    } else    
      System.out.println(Utils.makeBeauty("Laufzeit: Keine Messung durchgeführt."));
    
    // Wenn die Rechnung durchgeführt wurde, erneut fragen
    printCases();
  }
  
  /**
   * This function asks the user for a start, end and the number of random values to be generated and returns them
   *
   * @return the array of random generated numbers
   */
  static double[] printRandomner() {
    System.out.println("Zahlenbereich und Menge eingeben, in dem zufällige Zahlen generiert werden:"); 
    
    ///// DATEN ZUR ERZEUGUNG DER LISTE ABFRAGEN //////            
    int start, end, amount;
    // Frage Zahlenbereiche ab..
    System.out.print("Startwert: ");   
    start = Integer.parseInt(sc.nextLine().trim());       
    System.out.print("Endwert: ");   
    end = Integer.parseInt(sc.nextLine().trim());
    System.out.print("Zahlenmenge: ");   
    amount = Integer.parseInt(sc.nextLine().trim());
    ///////////////////////////////////////////////////
    
    System.out.println("Eingabe wird generiert..");  
    
    // Nimm die Doubles aus der Eingabe als Integer..
    double[] randomArray = Utils.generateRandom(start, end, amount);
    // Gib dem Nutzer das Array zurück und..
    System.out.println(Utils.makeBeauty("Generiert: " + Arrays.toString(randomArray)));
    
    // Fordere eine Bestätigung per Enterkommando - egal was kommt, danach weitermachen
    demandConfirmation();
    
    return randomArray;
  }
  
  /**
   * This function demands a confirmation with a key press to continue
   */
  static void demandConfirmation() {
    // Fordere eine Bestätigung per Enterkommando - egal was kommt, danach weitermachen
    System.out.println("Bitte mit Enter bestätigen: "); 
    sc.nextLine().trim();
  }
  
  /**
   * This function makes the input possible: It reads the last user input and splits it by the given splitter/seperator
   *
   * @param splitChar Requires a Regular Expression after which the input has to be seperated
   * @return the array of entered numbers
   */
  static double[] getDifferentNumbers(String splitChar) {
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
} // end of class Calc



