/* 
import java.util.Scanner;
public class pauseMenu{
    public static void show(Scanner input){
        System.out.println("\n===Game Paused===");
        System.out.println("1. Resume");
        System.out.println("2. Quit");
        System.out.print(">");

        boolean pauseMenuChoice = false;
        while(pauseMenuChoice == false){
            try{
                int choice = input.nextInt();
                switch(choice){
                    case 1 -> {
                        System.out.println("Resuming...");
                        pauseMenuChoice = true;
                    }
                    case 2 -> {
                        System.exit(0);
                        pauseMenuChoice = true;
                    }
                    default ->{
                        if(choice >2 || choice < 1){
                            System.out.println("Choice out of bounds.");
                        }
                    }
                }
            }
            catch(Exception e){
                ErrorHandler.handleInputError(e);
            }
        }
        input.close();
    }
}
*/