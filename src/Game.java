
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

    static void gameStart(Scanner input){
        System.out.println("Welcome to the future");
        System.out.print("Enter Username: \n>");
        String userName = input.nextLine();
        //setting initial userHealth to 0 before setting to corresponding value 
        Player player = new Player(userName, 100, 10, new Melee(), 0);
        
        System.out.print("Enter desired difficulty:\n 1. Easy\n 2. Medium\n3. Hard\n> ");
        boolean diffChoiceCorrect = false;
        while(diffChoiceCorrect == false){
            try{
                int difficulty = input.nextInt();
                input.nextLine();

                switch(difficulty){
                    case 1 -> {
                        System.out.println("You have chosen easy.");
                        diffChoiceCorrect = true;
                        player.setUserHealth(100);
                        Game.getInstance().setDifficulty(1);
                    }
                    case 2 -> {
                        System.out.println("You have chosen medium.");
                        diffChoiceCorrect = true;
                        player.setUserHealth(75); 
                        Game.getInstance().setDifficulty(2);
                    }
                    case 3 -> {
                        System.out.println("You have chosen hard.");
                        diffChoiceCorrect = true;
                        player.setUserHealth(50);
                        Game.getInstance().setDifficulty(3);
                    }
                }
            }
            catch(Exception e){
                ErrorHandler.handleInputError(e);
            }
        }
        gameRun(player, input);        
    }
    static void gameRun(Player player, Scanner input){
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