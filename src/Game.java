
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

    public int getDifficulty(){
        return difficulty;
    }
    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    static void gameStart(String userName, int difficulty){
        int playerHealth = switch (difficulty){
            case 1 -> 100;
            case 2 -> 75;
            case 3 -> 50;
            default -> 100;
        };
        Player player = new Player(userName, playerHealth, 0, new Melee(), 0);

        System.out.println("Welcome, "+player.getUserName()+"!");
        System.out.println("Difficulty: "+difficulty+ " | health: " + player.getUserHealth());
        System.out.println("Entering first room...\n");

        gameRun(player);        
    }
    static void gameRun(Player player){
        Scanner input = new Scanner(System.in);
        int roomCount = 1;
        while (player.getUserHealth() > 0){
            
            Room currentRoom = RoomFactory.createRoom();
            System.out.printf("Room %s, You have entered a %s.\n",roomCount, currentRoom.getRoomType());
            
            currentRoom.playerEnter(player, input);
            player.setPlayerScore(player.getPlayerScore()+1);
             
            RoomEndGUI.display();
            roomCount += 1;
        }
    }   
}