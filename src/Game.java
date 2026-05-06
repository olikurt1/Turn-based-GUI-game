import java.util.InputMismatchException;
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

    static void gameStart(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the future");
        System.out.print("Enter Username: \n>");
        String userName = input.nextLine();
        //setting initial userHealth to 0 before setting to corresponding value 
        Player player = new Player(userName, 100, true, 10, new Melee());
        
        boolean diffChoiceCorrect = false;
        while(diffChoiceCorrect == false){
            
            System.out.println("Enter desired difficulty: 1. Easy, 2. Medium, 3. Hard: ");
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
                default -> throw new InputMismatchException("Invalid number/value, does not adhere difficulty choice.");
            }
        }
        gameRun(player);

        
    }
    static void gameRun(Player player){
        int roomCount = 1;
        while (player.getUserLifeStatus()){
            Scanner input = new Scanner(System.in);
            
            System.out.printf("You have entered room %s.\n",roomCount);
            Room currentRoom = RoomFactory.createRoom();
            currentRoom.playerEnter(player);

             
            System.out.print("You have exited the room, What would you like to do?: \np: Pause\nc: Continue\n>");
            boolean validExitChoice = false;
            while(validExitChoice == false){
                String roomExitChoice = input.nextLine();

                if(roomExitChoice.toLowerCase().equals("p")){
                    pauseMenu.show();
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
            roomCount += 1;
        }
    }
    
}