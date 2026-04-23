import java.util.Scanner;

public class Game{
    
    static void gameStart(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Duel");
        System.out.println("Enter Username: ");
        String userName = input.nextLine();
        //setting initial userHealth to 0 before setting to corresponding value 
        Player player = new Player(userName, 100 );
        
        String difficulty = input.nextLine();

        switch(difficulty.toLowerCase()){
            case "easy" -> {
                player.setUserHealth(100);
            }
            case "medium" ->{
                player.setUserHealth(75); 
            }
            case "hard" -> {
                player.setUserHealth(50);
            }
        }
        input.close();
    } 
}