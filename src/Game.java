import java.util.Scanner;

public class Game{
    private static Game instance = null;
    private int difficulty;

    private Game(){
    }

    public static Game getInstance(){
        if (instance == null){
            instance = new Game();
        }
        return instance;
    }

    
    static void gameStart(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Duel");
        System.out.println("Enter Username: ");
        String userName = input.nextLine();
        //setting initial userHealth to 0 before setting to corresponding value 
        Player player = new Player(userName, 0 );
        
        System.out.println("Enter desired difficulty: 1. Easy, 2. Medium, 3. Hard: ");
        int difficulty = input.nextInt();

        switch(difficulty){
            case 1-> {
                System.out.println("You have chosen easy.");
                player.setUserHealth(100);
            }
            case 2 ->{
                System.out.println("You have chosen medium.");
                player.setUserHealth(75); 
            }
            case 3 -> {
                System.out.println("You have chosen hard.");
                player.setUserHealth(50);
            }
        }
        input.close();
    } 
}