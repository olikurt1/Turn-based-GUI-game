
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
             
            System.out.print("You have exited the room, What would you like to do?: \np: Pause\nc: Continue\n>");
            boolean validExitChoice = false;
            while(validExitChoice == false){
                try{
                    String roomExitChoice = input.nextLine();

                    if(roomExitChoice.toLowerCase().equals("p")){
                        pauseMenu.show(input);
                        validExitChoice = true;
                    }
                    else if(roomExitChoice.toLowerCase().equals("c")){
                        validExitChoice = true;
                        continue;  
                    }
                    else{
                        System.out.print("Invalid choice try again\n>");
                    }
                }
                catch(Exception e){
                    ErrorHandler.handleInputError(e);
                }
            }
            roomCount += 1;
        }
    }   
}