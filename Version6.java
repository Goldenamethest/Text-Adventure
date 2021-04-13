/**
 * Purpose: finish implementing items and add a win condition
 * 
 * @author Corwin
 * @version 26/03/21
 */

import java.util.Scanner;
public class Version6
{
  boolean running = false;
  Scanner input = new Scanner(System.in);
  String openingText = ("placeholder!");
  
 
   public Version6(){
      
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
    int itemSword = 3;
    int itemKey = 4;
    int password = 7;
    
   
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
                    
                case "read paper": 
                if(currentRoom==password){
                    itemSword=10;
                    System.out.println("the paper has 'password123' scribbled onto it.");
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
                    else if(northMovements[currentRoom]==5){
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
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
                    else if(southMovements[currentRoom]==5){
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
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
                    else if(westMovements[currentRoom]==5){
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
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
                    else if(eastMovements[currentRoom]==5){
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
                    }
                    else if(eastMovements[currentRoom]==3){
                        System.out.println("there are 11 dials on the door. Input a  password");
                        String passwordInput= input.nextLine();
                        if(passwordInput.equals("password123")){ 
                            currentRoom = 3;
                            System.out.println("the door swings open");
                        } else System.out.println("the password seems to be incorrect");
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
                    
                case "exit" : 
                if(currentRoom==1){
                   if (itemKey==10){
                    System.out.println("you win");
                    running=false;
                   } else System.out.println("you dont have the key");
                } else System.out.println("you are in the wrong room");
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
        if(currentRoom == password) System.out.println("there is a piece of paper with something written on it");
    }
}
