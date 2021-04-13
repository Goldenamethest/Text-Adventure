/**
 * Purpose: add in item and room descriptions
 * 
 * @author Corwin
 * @version 26/03/21
 */

import java.util.Scanner; //import scanners for input
public class Version7
{
  boolean running = false; //variable for running switch statement
  Scanner input = new Scanner(System.in); //creating input
  String openingText = ("You wake up in a cell dark, cold, cell. You don't know what you did to get in here, but you know you need to escape");                          
  
  
   String roomDesc[] = new String[8];
  
    int currentRoom= 0; //room the player is in
    
    int northMovements[] = {-1,-1,0,-1,-1,-1,2,1}; 
    int southMovements[] = {2,-1,6,-1,-1,-1,-1,-1};
    int westMovements[] = {-1,-1,1,2,-1,-1,5,6};
    int eastMovements[] = {-1,2,3,-1,-1,6,7,1};//linkages
    
    int itemCandle = 1; //the room that this item is in
    int itemSword = 3;
    int itemKey = 4;
    int password = 7; //the room you can find the password in
  
   public Version7(){
      
        startup(); // run startup protocol
        control(); // function containing the switch statment
        
     }
     
     String charName; 
    
   void startup(){ //startup protocol
       System.out.println(" _   _     _   _ _   _        _   _____        _       _      _             _                   ___                ");
       System.out.println("| | | |_ _| |_(_) |_| |___ __| | |_   _|____ _| |_    /_\\  __| |_ _____ _ _| |_ _  _ _ _ ___   / __|__ _ _ __  ___ ");
       System.out.println("| |_| | ' \\  _| |  _| / -_) _` |   | |/ -_) \\ /  _|  / _ \\/ _` \\ V / -_) ' \\  _| || | '_/ -_) | (_ / _` | '  \\/ -_)");
       System.out.println(" \\___/|_||_\\__|_|\\__|_\\___\\__,_|   |_|\\___/_\\_\\__|  /_/ \\_\\__,_|\\_/\\___|_||_\\__|\\_,_|_| \\___|  \\___\\__,_|_|_|_\\___|");
       System.out.println("                                                                                                                    ");
       System.out.println("input your name");
       charName = input.nextLine(); //stores character name
       System.out.println(openingText);
       running=true; //starts the controll loop
    }
   
   void control(){
        String command;
        while(running){ command = input.nextLine();
            switch (command) {
                case "look" :
                case "look around": describeRoom();
                    break;
                    
                
                case "take key" :
                case "get key" :
                case "pick up key": 
                if(currentRoom==itemKey){//check if player is in right room
                    itemKey=10;//move key to player inventory
                    System.out.println("you pick up the key");
                }
                else System.out.println("what key");
                    break;
                
                case "take candle" :
                case "get candle" :
                case "pick up candle": 
                if(currentRoom==itemCandle){ //check if player is in right room
                    itemCandle=10; //move candle to player inventory
                    System.out.println("you pick up the candle");
                }
                else System.out.println("what candle");
                    break;
                
                case "take sword" :
                case "get sword" :    
                case "pick up sword": 
                if(currentRoom==itemSword){//check if player is in right room
                    itemSword=10;//move sword to inventory
                    System.out.println("you pick up the sword");
                }
                else System.out.println("what sword");
                    break;    
                
                case "take paper" :
                case "get paper" :   
                case "pick up paper" :
                case "look at paper":
                case "read paper": 
                if(currentRoom==password){//check if player is in right room
                    System.out.println("the paper has 'password123' scribbled onto it.");
                }
                else System.out.println("what paper");
                    break;        
                 
                case "go north" :
                case "move north":
                case "north" : //north movement
                if(northMovements[currentRoom]==-1) //can the player move north?
                    System.out.println("you cant move north from here");
                    else if(northMovements[currentRoom]==6){ //area locked behind having the candle
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else if(northMovements[currentRoom]==5){//area locked behind having the sword
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
                    }
                    else currentRoom = northMovements[currentRoom]; //change the player's current location (currentRoom) to be north from the current room (northMovements[currentRoom])
                describeRoom();//describe the new room
                    break;
                
                case "go south" :
                case "move south":    
                case "south" : 
                if(southMovements[currentRoom]==-1)//can the player move south?
                    System.out.println("you cant move south from here");
                    else if(southMovements[currentRoom]==6){//area locked behind having the candle
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else if(southMovements[currentRoom]==5){//area locked behind having the sword
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
                    }
                    else currentRoom = southMovements[currentRoom]; //change the player's current location (currentRoom) to be south from the current room (southMovements[currentRoom])
                describeRoom();//describe the new room
                    break;
                
                case "go west" :
                case "move west":    
                case "west" : 
                if(westMovements[currentRoom]==-1)//can the player move south?
                    System.out.println("you cant move west from here");
                    else if(westMovements[currentRoom]==6){//area locked behind having the candle
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else if(westMovements[currentRoom]==5){//area locked behind having the sword
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
                    }
                    else currentRoom = westMovements[currentRoom];//change the player's current location (currentRoom) to be west from the current room (westMovements[currentRoom])
                describeRoom();//describe the new room
                    break;
                
                case "go east" :
                case "move east":    
                case "east" : 
                if(eastMovements[currentRoom]==-1)//can the player move east?
                    System.out.println("you cant move east from here");
                    else if(eastMovements[currentRoom]==6){//area locked behind having the candle
                        if(itemCandle!=10)System.out.println("that hallway is too dark");
                        else {System.out.println("the candle lights up the hallway"); currentRoom = 6;}
                    }
                    else if(eastMovements[currentRoom]==5){//area locked behind having the sword
                        if(itemSword!=10)System.out.println("a guard blocks your way");
                        else {System.out.println("you slay the guard with your sword"); currentRoom = 5;}
                    }
                    else if(eastMovements[currentRoom]==3){ //password input / area locked with a password
                        System.out.println("there are 11 dials on the door. Input a  password");
                        String passwordInput= input.nextLine();
                        if(passwordInput.equals("password123")){ 
                            currentRoom = 3;
                            System.out.println("the door swings open");
                        } else System.out.println("the password seems to be incorrect");
                    } 
                    else currentRoom = eastMovements[currentRoom]; //change the player's current location (currentRoom) to be east from the current room (eastMovements[currentRoom])
                describeRoom();//describe the new room
                    break;
                
                case "go up" :
                case "move up":    
                case "up" : 
                if(currentRoom==5){ //is the player in the base of the tower?
                    currentRoom = 4;//move to the top of the tower
                    describeRoom();//describe the new room
                }
                else System.out.println("you can't go up from here");
                    break;
                
                case "go down" :
                case "move down":    
                case "down" : 
                if(currentRoom==4){//is the player in the top of the tower?
                    currentRoom = 5; //move to the base of the tower
                    describeRoom();//describe the new room
                }
                else System.out.println("you can't go down from here");
                    break;
                 
                case "escape":  
                case "exit" : 
                if(currentRoom==1){ //is the player at the exit
                   if (itemKey==10){ //do they have the key?
                       winGame(); // win the game
                   } else System.out.println("you dont have the key");
                } else System.out.println("you are in the wrong room");
                    break;
                    
                case "win" : 
                System.out.println("it wont be that easy"); 
                    break;
                    
                default :  
                System.out.println("Sorry, I don't understand"); 
                    break; 
                
                case "quit":
                case "end" : //quit the game
                running = false; //stops the while loop from running
                    break;
                    
            }
            
        }
        
    }
    
    void winGame(){
        System.out.println("congratulations "+charName+", you win!");
        running=false; //stops the while loop
    }
    
    void describeRoom(){
        System.out.println("you are now in room" + currentRoom);
        System.out.println(roomDesc[currentRoom]);
        if(currentRoom == itemKey) System.out.println("there is a key on the floor of the room");
        if(currentRoom == itemSword) System.out.println("there is a sword on the floor of the room");
        if(currentRoom == itemCandle) System.out.println("there is a candle on the floor of the room");
        if(currentRoom == password) System.out.println("there is a piece of paper with something written on it");
        
        
        roomDesc[0] = "You are in the cell that you woke up in. There seems to be a hallway to your south";
        roomDesc[1] = "You are in a large room. There is a large door that is surely the exit, but it is locked. To your east there is a long hallway.";
        roomDesc[2] = "You are in a long hallway, lined with other cells. Your cell is to your north, to your south is a dark hallway, to your east is a closed door with 11 dials on it, and to your west is a large, well lit room";
        roomDesc[3] = "You are in a small room, used as storage for weaponry. You can exit back to the hallway to your west";
        roomDesc[4] = "You are at the top of the guard tower. Only way to go from here is down.";
        roomDesc[5] = "You are at the bottom of the guard tower. You can take the stairs up, or go back to the dark hallway to your east.";
        roomDesc[6] = "You are in a dim hallway. The gloom is illuminated by your candle, showing that you can go north back to the long hall, west to the guard tower, or east to a small closet.";
        roomDesc[7] = "You are in what seems to be a supply closet. You can go back to the dark hallway to the west.";
        //declaring the room descriptions
    }
}
