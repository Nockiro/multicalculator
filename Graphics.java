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
    // 79 Zeichen möglich
    
    
    for (int i = 0; i< fullList.size() -1; i++ ) {
      System.out.print(printPart(fullList.subList(i, i+ Math.max(fullList.size() - i, 79))));
      try {
       Thread.sleep(500);
      } catch(Exception e) {
        
      } finally {
        
      } // end of try
    } // end of for
    
    return;
  }

  static String printPart(List<Double> part)
  {
    String output = "";
    Double highestNumber = Collections.max(part);
    int rowCount = (int) Math.round(Math.log(Math.abs(highestNumber)));
    
    for (int row = rowCount; row == 0 ; row-- ) {
      for (int i = 0; i < part.size() - 1 ; i++) {
        if (Math.log(Math.abs(part.get(i))) >= row) {
          output += "#";
        } // end of if
      } // end of for
      output += "\r\n";
    } // end of for
    
    return output;
  }
  
}