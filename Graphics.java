/**
  *
  * Dient zur Visualisierung von Rechenmethoden
  * Diese Klasse enthält alle Methoden die derzeit zur Verfügung stehen um Rechenschritte zu visualisieren
  * 
  * @version 1.3 vom 20.01.2017
  * @author Robin Freund
  */
  
  
import java.util.*;  
import java.lang.*;

class Graphics {
  static void printWhole(List<Double> fullList) 
  { 
    // Define highest number and check, how high the Achterbahn shall be
    Double highestNumber = Collections.max(fullList);
    int rowCount = (int) Math.round(Math.log(Math.abs(highestNumber)));
    
    // Für jeden Wert in der Liste: alle 6 Zeilen generieren von i bis Konsolenbreite, danach um eins nach rechts in der Achterbahn rücken wenn der Platz nicht reicht
    // Generate for each value in the list the amount of lines we determined before from i up to the amount of chars to match the console width, then iterate one forward
    for (int i = 0; i< fullList.size() -1; i++) {   
      
      try {     
        // clear console and make it ready for the next animation "frame"
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();   
                  
        // Get frame for the current part of the list and print it
        String tempPrint = printPart(fullList.subList(i, i+ Math.min(fullList.size() - i, Calc.consoleWidth / 2)), rowCount);
        System.out.print(tempPrint);
        
        // make a pause - and scale it according to the list size
        Thread.sleep((long)(400 / Math.log(fullList.size())));
      } catch(Exception e) {
        // if there is any error, catch it and print it
        e.printStackTrace(System.out);
      } finally {
        // if there is no more output/frame to come from right, pause here
        if (fullList.size() - i <= Calc.consoleWidth / 2)
          break; 
      } // end of try
    } // end of for
    
    // Get a possibility for the user to have a look on the last part on the Achterbahn
    Calc.demandConfirmation();
    return;
  }
    
  static String printPart(List<Double> part, int rowCount)
  {
    // print debug information in the upper left corner
    System.out.println("RowCount: " + rowCount);
    System.out.println("Elements on this Screen: " + part.size());    
           
    String output = "";
    
    // Soviele Zeilen wie es an Höhe werden soll plus die für die Zahlen         
    // iterate through the loop as many times as we need to have the given amount of rows
    for (int row = rowCount + 1; row >= 0; row-- ) {
      // Depending on the scaled logarithm value, check if there has to be a representative character for each real value 
      for (int i = 0; i < part.size() - 1; i++) {
        if (Math.log(Math.abs(part.get(i))) >= row)
          output += "##";
        else
          output += "  ";
      } // end of for
      // new line, prepare next line for this frame
      output += "\r\n";
    } // end of for
    
    return output;
  }
    
}