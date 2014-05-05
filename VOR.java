/**
 *
 * @author Colten Yamamoto
 * @class ICS 314
 * @assignment VOR
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class VOR {
  
  public static void main(String args[]) {
    
    Calculation calc = new Calculation();
    Scanner scan = new Scanner(System.in);
    String[][] indicator = new String[13][13];
    int input = 0;
       
    try {
      while(input >= 0 && input < 360) {
        calc.UpdateVOR(indicator, input);
        System.out.print("New OBS: ");
        input = scan.nextInt();
      }
      System.out.println("Closing program...");
    } catch(InputMismatchException ime) {
      System.out.println("Inputed degree is invalid.  Closing program...");
    }
  }
}