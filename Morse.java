/**
 * 
 * A class for a VOR that creates a randomly generated 3 letter string that is converted
 * into Morse Code.
 * 
 * @author Dominique Vacca Farley
 * @edited Colten Yamamoto
 */

import java.util.*;
import java.lang.Math.*;

public class Morse  {

   private String input, morse = "", generatedString = "";
   private char[] charArrayInput;
   private int i, i2, randomNumber;
   private Random random = new Random();
   private String code;
   
   //Constructor, used to generate a 3 letter string, which is converted into Morse
   //Code.
   public Morse() {
     String temp = generateString();
     code = toMorse(temp);
   }
   
   //Generate random 3-letter string:
   public String generateString()   {
      for(i2 = 0; i < 3; i++) {
         randomNumber = (int)(Math.random() * 27.0);
         switch(randomNumber) {
            case 0:
               generatedString += "A";
               break;
            case 1:
               generatedString += "B";
               break;
            case 2:
               generatedString += "C";
               break;
            case 3:
               generatedString += "D";
               break;
            case 4:
               generatedString += "E";
               break;
            case 5:
               generatedString += "F";
               break;
            case 6:
               generatedString += "G";
               break;
            case 7:
               generatedString += "H";
               break;
            case 8:
               generatedString += "I";
               break;
            case 9:
               generatedString += "J";
               break;
            case 10:
               generatedString += "K";
               break;
            case 11:
               generatedString += "L";
               break;
            case 12:
               generatedString += "M";
               break;
            case 13:
               generatedString += "N";
               break;
            case 14:
               generatedString += "O";
               break;
            case 15:
               generatedString += "P";
               break;
            case 16:
               generatedString += "Q";
               break;
            case 17:
               generatedString += "R";
               break;
            case 18:
               generatedString += "S";
               break;
            case 19:
               generatedString += "T";
               break;
            case 20:
               generatedString += "U";
               break;
            case 21:
               generatedString += "V";
               break;
            case 22:
               generatedString += "W";
               break;
            case 23:
               generatedString += "X";
               break;
            case 24:
               generatedString += "Y";
               break;
            case 25:
               generatedString += "Z";
               break;
            default:
               if(randomNumber < 0) {
                  generatedString += "A";
               }else {
                  generatedString += "Z";
               }
               break;
         }//switch
      }//for
      
      return generatedString;
   }//generateString
   
   //Convert a 3-letter string to Morse code:
   public String toMorse(String s)  {      
      input = s.toUpperCase();
      charArrayInput = input.toCharArray();
      
      for(i = 0; i < 3; i++)  {
         switch(charArrayInput[i])  {
           case 'A':
            morse += ".- //";
            break;
           case 'B':
            morse += "-... //";
            break;
           case 'C':
            morse += "-.-. //";
            break;
           case 'D':
            morse += "-.. //";
            break;
           case 'E':
            morse += ". //";
            break;
           case 'F':
            morse += "..-. //";
            break;
           case 'G':
            morse += "--. //";
            break;
           case 'H':
            morse += ".... //";
            break;
           case 'I':
            morse += ".. //";
            break;
           case 'J':
            morse += ".--- //";
            break;
           case 'K':
            morse += "-.- //";
            break;
           case 'L':
            morse += ".-.. //";
            break;
           case 'M':
            morse += "-- //";
            break;
           case 'N':
            morse += "-. //";
            break;
           case 'O':
            morse += "--- //";
            break;
           case 'P':
            morse += ".--. //";
            break;
           case 'Q':
            morse += "--.- //";
            break;
           case 'R':
            morse += ".-. //";
            break;
           case 'S':
            morse += "... //";
            break;
           case 'T':
            morse += "- //";
            break;
           case 'U':
            morse += "..- //";
            break;
           case 'V':
            morse += "...- //";
            break;
           case 'W':
            morse += ".-- //";
            break;
           case 'X':
            morse += "-..- //";
            break;
           case 'Y':
            morse += "-.-- //";
            break;
           case 'Z':
            morse += "--.. //";
            break;
         }//switch
      }//for
      
      return morse;
   }//toMorse

   //Returns the Morse Code as a String.
   public String getCode() {
     return code;
   }
   
}//class