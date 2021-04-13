/**
 * Purpose: add movement between some rooms and organise into void functions
 * 
 * @author Corwin
 * @version 25/03/21
 */

import java.util.Scanner;
public class version3
{
  boolean running = false;
  Scanner input = new Scanner(System.in);
  String openingText = ("placeholder!");
  
  String charName;
  int currentRoom= 0;
 
  
   public version3(){
      
        startup();
        control();
      
     }
    
    
   void startup(){
       System.out.println("input your name");
       charName = input.nextLine();
       System.out.println(openingText);
       running=true;
    }
    
    
   void control(){
        String command;
        while(running){ command = input.nextLine();
            switch (command) {
                case "north" : moveNorth(); System.out.println("you are now in room" +currentRoom);
                    break;
                    
                case "south" : moveSouth(); System.out.println("you are now in room" +currentRoom);
                    break;
                
                case "east" : moveEast(); System.out.println("you are now in room" +currentRoom);
                    break;
                    
                case "west" : moveWest(); System.out.println("you are now in room" +currentRoom);
                    break;
                    
                case "win" : System.out.println("it wont be that easy"); 
                    break;
                    
                default :  System.out.println("Sorry, I don't understand"); 
                    break;
                    
                case "end" : running = false;
                    break;
                    
            }
            
        }
    }
    
    int northMovements[] = new int[8];
    void moveNorth(){
        northMovements[2]=0;
        northMovements[6]=2;
        northMovements[7]=1;
        currentRoom = northMovements[currentRoom];
    }
    
    int southMovements[] = new int[8];
    void moveSouth(){
        southMovements[0]=2;
        southMovements[2]=6;
        currentRoom = southMovements[currentRoom];
    }
    
    int eastMovements[] = new int[8];
    void moveEast(){
        eastMovements[2]=3;
        eastMovements[1]=2;
        eastMovements[5]=6;
        eastMovements[6]=7;
        eastMovements[7]=1;
        currentRoom = eastMovements[currentRoom];
    }
    
    int westMovements[] = new int[8];
    void moveWest(){
        westMovements[3]=2;
        westMovements[2]=1;
        westMovements[6]=5;
        westMovements[7]=6;
        currentRoom = westMovements[currentRoom];
    }
}
