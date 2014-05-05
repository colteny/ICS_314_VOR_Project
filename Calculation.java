/**
 * A class that contains the calculations required to run a VOR for VOR.java.
 * 
 * @author Colten Yamamoto
 * @class ICS 314
 * @assignment VOR
 */

public class Calculation {
  
  private int angle;          //Radical where station is located.
  private int upperBound;     //angle + 90 degrees.
  private int lowerBound;     //angle - 90 degrees.
  private boolean signal;     //Good = true.  Bad = false;
  private boolean direction;  //To = true.  From = false.
  
  //A constructor that initializes variables.  The angle is randomly created to represent
  //where the station is relative to the plane.  (VOR always starts at magnetic north,
  //heading towards the station.)
  public Calculation() {
    angle = (int) (Math.random() * 360 + 1);
    int temp = (int) Math.round(Math.random());
    if(temp == 1) {
      signal = true;
    } else {
      signal = false;
    }
    direction = true;

    upperBound = angle + 90;
    lowerBound = angle - 90;
    if(upperBound >= 360) {
      upperBound = upperBound - 360;
    }
    if(lowerBound < 0) {
      lowerBound = lowerBound + 360;
    }
    
  }
  
  //Checks the signal of an inputed OBS.  If the signal is already bad, the method
  //will always return false.  If it is good, then it is checked if the plane is "abeam,"
  //in which case the signal is bad and the method will return false.  If the plane is
  //not "abeam," then the signal is good and the method will return true.
  public boolean GoodBadSignal(int OBS) {
    
    //If the signal is good, then the statement checks whether the plane is abeam to the
    //station.  If yes, then the signal is bad.  If not, then the signal is good.
    //If the signal was initally bad, then the signal will always be bad.
    if(signal == true) {
      if(OBS == upperBound || OBS == lowerBound) {
        return false;
      } else {
        return true;
      }
    } else {
      return false;
    }
  }
  
  //Checks whether the plane is going to or from the station after inputing a new OBS.
  //Returns true if the new angle has the plane head towards the station or false if
  //the angle has the plane head away from the station.
  public boolean ToFrom(int OBS) {
    
    //If the plane is going to the station, then the statement checks whether the new
    //angle sets the plane going to or from the station.  If the plane is going away from
    //the station, then the same is checked, but returns opposite results.
    if(direction == true) {
      if(Math.abs(OBS - angle) < 90) {
        return true;
      } else {
        return false;
      }
    } else {
      if(Math.abs(OBS - angle) < 90) {
        return false;
      } else {
        return true;
      }
    }
  }
  
  public void CreateVOR(String[][] vor) {
    for(int r = 0; r < vor.length; r++) {
      for(int c = 0; c < vor[r].length; c++) {
        vor[r][c] = "   ";
      }
    }

    for(int x = 2; x < vor.length-2; x++) {
      if(x != vor.length/2) {
        vor[vor.length/2][x] = " O ";
      }
    }
  }
  
  public String FormatOBS(int OBS) {
    
    if(OBS >= 360) {
      OBS = OBS - 360;
    } else if(OBS < 0) {
      OBS = OBS + 360;
    }
    
    if(OBS < 10) {
      return " " + OBS + " ";
    } else if(OBS < 100) {
      return OBS + " ";
    } else {
      return "" + OBS;
    }
    
  }
  
  public void UpdateVOR(String[][] vor, int OBS) {
    boolean newSignal = GoodBadSignal(OBS);
    boolean newDirection = ToFrom(OBS);
    int deflection = angle - OBS;
    if(angle >= 180) {
      deflection = deflection * -1;
    }
    
    CreateVOR(vor);
    
    if(deflection < -1) {
      if(deflection <= -10) {
        vor[6][1] = " X ";
        vor[5][2] = " X ";
        vor[4][3] = " X ";
        vor[3][4] = " X ";
        vor[2][5] = " X ";
        vor[1][6] = " X ";
      } else if(deflection <= -8) {
        vor[5][2] = " X ";
        vor[4][3] = " X ";
        vor[3][4] = " X ";
        vor[2][5] = " X ";
        vor[1][6] = " X ";
      } else if(deflection <= -6) {
        vor[5][3] = " X ";
        vor[4][4] = " X ";
        vor[3][4] = " X ";
        vor[2][5] = " X ";
        vor[1][6] = " X ";
      } else if(deflection <= -4) {
        vor[5][4] = " X ";
        vor[4][4] = " X ";
        vor[3][5] = " X ";
        vor[2][5] = " X ";
        vor[1][6] = " X ";
      } else if(deflection <= -2) {
        vor[5][5] = " X ";
        vor[4][5] = " X ";
        vor[3][5] = " X ";
        vor[2][6] = " X ";
        vor[1][6] = " X ";
      }
      
    } else if(deflection > 1) {
      if(deflection >= 10) {
        vor[6][vor.length-2] = " X ";
        vor[5][vor.length-3] = " X ";
        vor[4][vor.length-4] = " X ";
        vor[3][vor.length-5] = " X ";
        vor[2][vor.length-6] = " X ";
        vor[1][vor.length-7] = " X ";
      } else if(deflection >= 8) {
        vor[5][vor.length-3] = " X ";
        vor[4][vor.length-4] = " X ";
        vor[3][vor.length-5] = " X ";
        vor[2][vor.length-6] = " X ";
        vor[1][vor.length-7] = " X ";
      } else if(deflection >= 6) {
        vor[5][vor.length-4] = " X ";
        vor[4][vor.length-4] = " X ";
        vor[3][vor.length-5] = " X ";
        vor[2][vor.length-6] = " X ";
        vor[1][vor.length-7] = " X ";
      } else if(deflection >= 4) {
        vor[5][vor.length-5] = " X ";
        vor[4][vor.length-5] = " X ";
        vor[3][vor.length-6] = " X ";
        vor[2][vor.length-6] = " X ";
        vor[1][vor.length-7] = " X ";
      } else if(deflection >= 2) {
        vor[5][vor.length-6] = " X ";
        vor[4][vor.length-6] = " X ";
        vor[3][vor.length-6] = " X ";
        vor[2][vor.length-7] = " X ";
        vor[1][vor.length-7] = " X ";
      }
    } else {
      for(int i = 1; i < vor.length/2; i++) {
        vor[i][vor.length/2] = " X ";
      }
    }
    vor[0][vor.length/2] = FormatOBS(OBS);
    vor[vor.length-1][vor.length/2] = FormatOBS(OBS + 180);
    vor[vor.length/2][0] = FormatOBS(OBS + 270);
    vor[vor.length/2][vor.length-1] = FormatOBS(OBS + 90);
    
    PrintVOR(vor, OBS, newSignal, newDirection);
    
  }
  
  public void PrintVOR(String[][] vor, int OBS, boolean sig, boolean dir) {
    for(int r = 0; r < vor.length; r++) {
      for(int c = 0; c < vor[r].length; c++) {
        System.out.print(vor[r][c]);
      }
      System.out.println();
    }
    System.out.print("Direction: ");
    if(dir == true) {
      System.out.print("TO\t\t");
    } else {
      System.out.print("FROM\t\t");
    }
    System.out.print("Signal: ");
    if(sig == true) {
      System.out.print("GOOD\t\t");
    } else {
      System.out.print("BAD\t\t");
    }
    System.out.println();
    System.out.println("OBS: " + OBS + "\t\tRadical: " + angle);
  }
}