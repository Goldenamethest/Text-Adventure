/**
 * Purpose: finish movement & map layout
 * 
 * @author Corwin
 * @version 26/03/21
 */

import java.util.Scanner;
public class Version4
{
  boolean running = false;
  Scanner input = new Scanner(System.in);
  String openingText = ("placeholder!");
  
  String charName;
  int currentRoom= 0;
 
  
   public Version4(){
      
        startup();
        control();
      
     }
    
    
   void startup(){
       System.out.println("input your name");
       charName = input.nextLine();
       System.out.println(openingText);
       running=true;
    }
    
    int northMovements[] = {-1,-1,0,-1,-1,-1,2,1};
    int southMovements[] = {2,-1,6,-1,-1,-1,-1,-1};
    int westMovements[] = {-1,-1,1,2,-1,-1,5,6};
    int eastMovements[] = {-1,2,3,-1,-1,6,7,1};
    
   
   void control(){
        String command;
        while(running){ command = input.nextLine();
            switch (command) {
                
                case "north" : 
                if(northMovements[currentRoom]==-1)
                    System.out.println("you cant move north from here");
                    else currentRoom = northMovements[currentRoom];
                System.out.println("you are now in room" + currentRoom);
                    break;
                    
                case "south" : 
                if(southMovements[currentRoom]==-1)
                    System.out.println("you cant move south from here");
                    else currentRoom = southMovements[currentRoom]; 
                System.out.println("you are now in room" + currentRoom);
                    break;
                
                case "west" : 
                if(westMovements[currentRoom]==-1)
                    System.out.println("you cant move west from here");
                    else currentRoom = westMovements[currentRoom];
                System.out.println("you are now in room" + currentRoom);
                    break;
                    
                case "east" : 
                if(eastMovements[currentRoom]==-1)
                    System.out.println("you cant move east from here");
                    else currentRoom = eastMovements[currentRoom]; 
                System.out.println("you are now in room" + currentRoom);
                    break;
                
                case "up" : 
                if(currentRoom==5){
                    currentRoom = 4;
                    System.out.println("you are now in room" + currentRoom);
                }
                else System.out.println("you can't go up from here");
                    break;
                    
                case "down" : 
                if(currentRoom==4){
                    currentRoom = 5; 
                    System.out.println("you are now in room" + currentRoom);
                }
                else System.out.println("you can't go down from here");
                    break;
                    
                case "win" : 
                System.out.println("it wont be that easy"); 
                    break;
                    
                default :  
                System.out.println("Sorry, I don't understand"); 
                    break;
                    
                case "end" : 
                running = false;
                    break;
                    
            }
            
        }
        
    }
    
}
