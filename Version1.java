/**
 * Purpose: Receive basic input
 * 
 * @author Corwin
 * @version 19/03/21
 */

import java.util.Scanner;
public class Version1
{
  boolean running = true;
  Scanner input = new Scanner(System.in);
  String command = input.nextLine();
  public Version1(){
      while(running){ 
            switch (command) {
                case "win" : System.out.println("it wont be that easy"); 
                command = input.nextLine();
                    break;
                default :  System.out.println("Sorry, I don't understand"); 
                command = input.nextLine();
                    break;
            }
        }
    }
}
