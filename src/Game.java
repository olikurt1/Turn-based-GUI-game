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
        System.out.println("Enter Username: ");
        String userName = input.nextLine();
        //setting initial userHealth to 0 before setting to corresponding value 
        Player player = new Player(userName, 100, true );
        
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
                default -> throw new IllegalArgumentException("Invalid number, does not adhere difficulty choice.");
            }

        } 

        input.close();
    }
    static void gameLoad(Player player){
        while (player.getUserLifeStatus()){
            Room createCurrentRoom = RoomFactory.createRoom();
        }
    } 
}