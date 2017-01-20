/*    **
*   ***
*  ******************************************************
*   ***
*     **
*
*/
      
  
import java.util.*;  
import java.lang.*;

class Graphics {
  static void printWhole(List<Double> fullList) 
  { 
    // Define highest number and check, how high the Achterbahn shall be
    Double highestNumber = Collections.max(fullList);
    int rowCount = (int) Math.round(Math.log(Math.abs(highestNumber)));
    
    // Für jeden Wert in der Liste: alle 6 Zeilen generieren von i bis 79 (Konsolenbreite), danach um eins nach rechts in der Achterbahn rücken wenn der Platz nicht reicht
    for (int i = 0; i< fullList.size() -1; i++) {   
      
      try {           
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();             
        String tempPrint = printPart(fullList.subList(i, i+ Math.min(fullList.size() - i, Calc.consoleWidth / 2)), rowCount);
        if (!tempPrint.equals(""))
          System.out.print(tempPrint);
        // Skaliere die Geschwindigkeit je nach Länge der Achterbahn
        Thread.sleep((long)(400 / Math.log(fullList.size())));
      } catch(Exception e) {
        e.printStackTrace(System.out);
      } finally {
        // if there is no more output to come from right, pause here
        if (fullList.size() - i <= Calc.consoleWidth / 2)
          break; 
      } // end of try
    } // end of for
    
    Calc.demandConfirmation();
    return;
  }
    
  static String printPart(List<Double> part, int rowCount)
  {
    String output = "";
    System.out.println("RowCount: " + rowCount);
    System.out.println("Elements on this Screen: " + part.size());
    // Soviele Zeilen wie es an Höhe werden soll plus die für die Zahlen
    for (int row = rowCount + 1; row >= 0; row-- ) {
      for (int i = 0; i < part.size() - 1; i++) {
        if (Math.log(Math.abs(part.get(i))) >= row)
          output += "##";
        else
          output += "  ";
      } // end of for
      output += "\r\n";
    } // end of for
    
    return output;
  }
    
}