
import java.util.Scanner;

public class Game{
    private static Game instance = null;
    private int difficulty;
    public Player player;

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

    public void gameStart(String userName, int difficulty){
        int playerHealth = switch (difficulty){
            case 1 -> 100;
            case 2 -> 75;
            case 3 -> 50;
            default -> 100;
        };
        this.player = new Player(userName, playerHealth, 0, new Melee(), 0);
        startNextRoom();

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
             
            
            roomCount += 1;
        }
    } 
    //refactoring gameRun loop to accomodate switch to GUI interface
    public void startNextRoom(){
        Room currentRoom = RoomFactory.createRoom();
        if (currentRoom instanceof FightRoom fightRoom){
            FightRoomPanel panel = (FightRoomPanel)getPanelFor("FIGHT");
            panel.loadRoom(fightRoom);
            GameWindow.instance.switchTo("FIGHT");
        }
        else if(currentRoom instanceof HealRoom healRoom){
            HealRoomPanel panel = (HealRoomPanel) getPanelFor("HEAL");
            panel.loadRoom(healRoom);
            GameWindow.instance.switchTo("HEAL");
        }
        else{
            GameWindow.instance.switchTo("ROOM END");
        }
        player.setPlayerScore(player.getPlayerScore() + 1);

    }
    private java.awt.Component getPanelFor(String name){
        for (java.awt.Component component : GameWindow.instance.cardPanel.getComponents()){
            if(name.equals("FIGHT") && component instanceof FightRoomPanel){
                return component;
            }
            if(name.equals("HEAL") && component instanceof HealRoomPanel){
                return component;
            }
            return null;
        }
    }
}