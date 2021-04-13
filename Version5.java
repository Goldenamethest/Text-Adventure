/**
 * Purpose: add items
 * 
 * @author Corwin
 * @version 26/03/21
 */

import java.util.Scanner;
public class Version5
{
  boolean running = false;
  Scanner input = new Scanner(System.in);
  String openingText = ("placeholder!");
  
 
   public Version5(){
      
        startup();
        control();
      
     }
     
     String charName;
    
   void startup(){
       System.out.println("input your name");
       charName = input.nextLine();
       System.out.println(openingText);
       running=true;
    }
    
    int currentRoom= 0;
    
    int northMovements[] = {-1,-1,0,-1,-1,-1,2,1};
    int southMovements[] = {2,-1,6,-1,-1,-1,-1,-1};
    int westMovements[] = {-1,-1,1,2,-1,-1,5,6};
    int eastMovements[] = {-1,2,3,-1,-1,6,7,1};
    
    int itemCandle = 1;
    int itemSword = 7;
    int itemKey = 4;
    
   
   void control(){
        String command;
        while(running){ command = input.nextLine();
            switch (command) {
                
                case "look around": describeRoom();
                    break;
                    
                case "escape": //FILL THIS IS if(itemKey==10) ifroom==1
                
                case "pick up key": 
                if(currentRoom==itemKey){
                    itemKey=10;
                    System.out.println("you pick up the key");
                }
                else System.out.println("what key");
                    break;
                
                case "pick up candle": 
                if(currentRoom==itemCandle){
                    itemCandle=10;
                    System.out.println("you pick up the candle");
                }
                else System.out.println("what candle");
                    break;
                
                case "pick up sword": 
                if(currentRoom==itemSword){
                    itemSword=10;
                    System.out.println("you pick up the sword");
                }
                else System.out.println("what sword");
                    break;    
                    
                case "north" : 
                if(northMovements[currentRoom]==-1)
                    System.out.println("you cant move north from here");
                    else if(northMovements[currentRoom]==6){
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else currentRoom = northMovements[currentRoom];
                describeRoom();
                    break;
                    
                case "south" : 
                if(southMovements[currentRoom]==-1)
                    System.out.println("you cant move south from here");
                    else if(southMovements[currentRoom]==6){
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else currentRoom = southMovements[currentRoom]; 
                describeRoom();
                    break;
                
                case "west" : 
                if(westMovements[currentRoom]==-1)
                    System.out.println("you cant move west from here");
                    else if(westMovements[currentRoom]==6){
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else currentRoom = westMovements[currentRoom];
                describeRoom();
                    break;
                    
                case "east" : 
                if(eastMovements[currentRoom]==-1)
                    System.out.println("you cant move east from here");
                    else if(eastMovements[currentRoom]==6){
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else currentRoom = eastMovements[currentRoom]; 
                describeRoom();
                    break;
                
                case "up" : 
                if(currentRoom==5){
                    currentRoom = 4;
                    describeRoom();
                }
                else System.out.println("you can't go up from here");
                    break;
                    
                case "down" : 
                if(currentRoom==4){
                    currentRoom = 5; 
                    describeRoom();
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
    
    void describeRoom(){
        System.out.println("you are now in room" + currentRoom);
        if(currentRoom == itemKey) System.out.println("there is a key on the floor of the room");
        if(currentRoom == itemSword) System.out.println("there is a sword on the floor of the room");
        if(currentRoom == itemCandle) System.out.println("there is a candle on the floor of the room");
    }
}
