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
        this.difficulty = difficulty;
        int playerHealth = switch (difficulty){
            case 1 -> 100;
            case 2 -> 75;
            case 3 -> 50;
            default -> 100;
        };
        this.player = new Player(userName, playerHealth, 0, new Melee(), 0);
        startNextRoom();        
    }
    
 
    //refactoring gameRun loop to accomodate switch to GUI interface
    public void startNextRoom(){
        Room currentRoom = RoomFactory.createRoom();
        if (currentRoom instanceof FightRoom fightRoom){
            FightRoomPanel panel = (FightRoomPanel)getPanelFor("FIGHT");
            panel.loadRoom(fightRoom);
            GameWindow.instance.switchTo("FIGHT");
            player.setPlayerScore(player.getPlayerScore() + 1);
        }
        else if(currentRoom instanceof HealRoom healRoom){
            HealRoomPanel panel = (HealRoomPanel) getPanelFor("HEAL");
            panel.loadRoom(healRoom);
            GameWindow.instance.switchTo("HEAL");
        }
        else{
            GameWindow.instance.switchTo("ROOM END");
        }
        

    }
    //Classifies each panel within the GameWindow singleton as their generic type of Component, overall function is used to return a specific room panel when startNextRoom is called. It runs certain room by checking the panels name and if its generic component is definitely an instanceof that type. 
    //Loops through the CardLayout 'deck of cards GUI's that have all loaded on each other instantly with the window 
    private java.awt.Component getPanelFor(String name){
        for (java.awt.Component component : GameWindow.instance.cardPanel.getComponents()){
            if(name.equals("FIGHT") && component instanceof FightRoomPanel){
                return component;
            }
            if(name.equals("HEAL") && component instanceof HealRoomPanel){
                return component;
            }
        }
        return null;
    }
}