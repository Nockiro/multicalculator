class Sortings {
  
  static double[] doBubbleSort(double[] ParamNumbers) {
    
    // Variablen initialisieren
    boolean unsortiert = true;
    double temp;
    
    while (unsortiert){
      unsortiert = false;
      for (int i=0; i < ParamNumbers.length-1; i++) 
        if (ParamNumbers[i] > ParamNumbers[i+1]) {
          ParamNumbers = Utils.tauscheItem(ParamNumbers, i, i+1);
          unsortiert = true;
        }          
    } 
    return ParamNumbers;
  }
  
  static double[] doInsertSort(double[] ParamNumbers) {
    
    // Variablen initialisieren
    boolean unsortiert = true;
    double temp;
    
    // Jede Stelle im Array durchgehen..
    for (int i = 0; i < ParamNumbers.length; i++) {
      int a = i;
      // Sofern i bzw. a nicht 0 ist, bei jeder Stelle im Array solange rückwärts gehen...
      while (a != 0) { 
        // ... bis z.B. der aktuelle Wert größer ist als der an der vorherigen Stelle - dann ist der Wert schon sortiert
        if (ParamNumbers[a] > ParamNumbers[a-1])
          break;
          // Wenn der vorherige Wert größer ist als der aktuelle, dann stelle den Wert um eins zurück und 
          // laufe in der Schleife solange rückwärts, bis der Wert der größte Wert ist, den es bis zu dieser Stelle gibt
        else {   
          /// Tausche Wert an der Stelle a mit dem an der Stelle vor a               
          ParamNumbers = Utils.tauscheItem(ParamNumbers, a, a-1);
          // Eine Stelle rückwärts gehen
          a--;    
        } // end of if-else
      } // end of while
    } // end of for
    return ParamNumbers;
  }
  
  static double[] doQuickSort(double[] ParamNumbers, int lowerIndex, int higherIndex) {     
    // Variablen initialisieren
    boolean unsortiert = true;
    double temp, PositionINdex;
    
    // Array wäre sortiert
    if (lowerIndex >= higherIndex) {
      return ParamNumbers;
    } // end of if
    
    // Pivotelement, Mitte
    double pivot = ParamNumbers[lowerIndex + (higherIndex - lowerIndex) / 2];
    
    int LastMinimumLIndex = lowerIndex;   
    int LastMinimumHIndex = higherIndex;
    
    // Solange der "Zeiger" der linken Seite noch links vom Pivot und dem größeren Zeiger steht, weitermachen
    while (LastMinimumLIndex < LastMinimumHIndex) {
      
      
      // Solange das Array durchsuchen, bis ein Element kleiner als das Pivot gefunden wurde
      /* for (int SearchIndex = LastMinimumLIndex; ParamNumbers[SearchIndex] < pivot; SearchIndex++) {
      LastMinimumLIndex = SearchIndex;
      }
      // Solange das Array durchsuchen, bis ein Element größer als das Pivot gefunden wurde
      for (int SearchIndex = LastMinimumHIndex; ParamNumbers[SearchIndex] > pivot; SearchIndex--) {
      LastMinimumHIndex = SearchIndex;
      }         */
      
      while (ParamNumbers[LastMinimumLIndex] < pivot) {
        LastMinimumLIndex++;
      }
      
      while (ParamNumbers[LastMinimumHIndex] > pivot) {
        LastMinimumHIndex--;
      }
      
      /// Achtung! Hier muss noch irgendwo der Wurm drin sein
      /* if (LastMinimumLIndex < LastMinimumHIndex) {
      Utils.tauscheItem(ParamNumbers, LastMinimumLIndex, LastMinimumHIndex);
      //Da Items getauscht, kann man sich die nächsten zwei anschauen
      LastMinimumLIndex++;
      LastMinimumHIndex--;
      }           */
      if (LastMinimumLIndex <= LastMinimumHIndex) {
        double temp1 = ParamNumbers[LastMinimumLIndex];
        ParamNumbers[LastMinimumLIndex] = ParamNumbers[LastMinimumHIndex];
        ParamNumbers[LastMinimumHIndex] = temp1;
        LastMinimumLIndex++;
        LastMinimumHIndex--;
      }
      
    }
    
    // doQuickSort rekursiv aufrufen, wenn der kleinere Index noch unter dem letzten gefundenen Höheren liegt
    if (lowerIndex < LastMinimumHIndex)
      doQuickSort(ParamNumbers, lowerIndex, LastMinimumHIndex);
    //   
    if (LastMinimumLIndex < higherIndex)
      doQuickSort(ParamNumbers, LastMinimumLIndex, higherIndex);
    
    return ParamNumbers;
  }
  
  static double[] doSelectionSort(double[] ParamNumbers) {  
    // Variablen initialisieren
    boolean unsortiert = true;
    double temp;
    
    for (int PositionIndex = 0; PositionIndex < ParamNumbers.length; PositionIndex++) {
      int LastMinimumIndex = PositionIndex;
      
      for (int SearchIndex = PositionIndex + 1; SearchIndex < ParamNumbers.length; SearchIndex++) {
        if (ParamNumbers[LastMinimumIndex] > ParamNumbers[SearchIndex])
          LastMinimumIndex = SearchIndex;
      } // end of for                              
      ParamNumbers = Utils.tauscheItem(ParamNumbers, PositionIndex, LastMinimumIndex);
    }
    
    return ParamNumbers;
  }
}