import java.util.Scanner;
public class startMenu{
    public static void show(Scanner input){
        System.out.println("\n===Start Menu===");
        System.out.println("1.Start Game");
        System.out.println("2.Quit");
        System.out.print(">");

        boolean startMenuChoice = false;
        while(startMenuChoice == false){
            try{
                int choice = input.nextInt();
                input.nextLine();
                switch(choice){
                    case 1 ->{
                        System.out.println("Starting Game...");
                        Game.gameStart(input);
                        startMenuChoice = true;
                    }
                    case 2 ->{
                        System.out.println("Quitting...");
                        System.exit(0);
                        startMenuChoice = true;
                    }
                    default ->{
                        System.out.println("Invalid choice, choose again.");
                    }
                }
            }
            catch(Exception e){
                ErrorHandler.handleInputError(e);
            }
        }
    } 
}