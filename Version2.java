/**
 * Purpose: have a basic startup and ad an kill command
 * 
 * @author Corwin
 * @version 24/03/21
 */

import java.util.Scanner;
public class Version2
{
  boolean running = false;
  Scanner input = new Scanner(System.in);
  String openingText = ("placeholder!");
  public Version2(){
      if(running==false){
          System.out.println("input your name");
          String characterName = input.nextLine();
          System.out.println(openingText);
          running=true;
        }
      
      String command = input.nextLine();
      while(running){ 
            switch (command) {
                case "win" : System.out.println("it wont be that easy"); 
                command = input.nextLine();
                    break;
                default :  System.out.println("Sorry, I don't understand"); 
                command = input.nextLine();
                    break;
                case "end" : running = false;
                    break;
            }
        }
    }
}
