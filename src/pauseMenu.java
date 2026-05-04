import java.util.Scanner;
public class pauseMenu{
    public static void show(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n===Game Paused===");
        System.out.println("1. Resume");
        System.out.println("2. Quit");

        int choice = input.nextInt();
        switch(choice){
            case 1 -> System.out.println("Resuming...");
            case 2 -> System.exit(0);
        }
        input.close();
    }
}