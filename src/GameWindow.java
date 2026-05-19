import javax.swing.*;
import java.awt.*;
//this is the actual window that the game loads into when main runs it makes all GUI's load into one window rather than opening separate windows and separate threads
public class GameWindow extends JFrame{
    //cardLayout type means all GUI's load at once and stack on top of each other
    private CardLayout cardLayout = new CardLayout();
    public JPanel cardPanel =  new JPanel(cardLayout);

    //singleton
    public static GameWindow instance = null;
    //declaring each GUI as an attribute of game window
    private FightRoomPanel fightRoomPanel = new FightRoomPanel();
    private HealRoomPanel healRoomPanel = new HealRoomPanel();
    private RoomEndGUI roomEndPanel = new RoomEndGUI();
    private GameOverPanel gameOverPanel = new GameOverPanel();
    private RoomEndEnemyGUI enemyRoomEndPanel = new RoomEndEnemyGUI();

    public GameWindow(){
        instance = this;
        setTitle("AI Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        //each cardPanel is one of the GUI's
        cardPanel.add(new startMenuGUI(), "START");
        cardPanel.add(new PauseMenuGUI(), "PAUSE");
        cardPanel.add(roomEndPanel, "ROOM END");
        cardPanel.add(fightRoomPanel, "FIGHT");
        cardPanel.add(healRoomPanel, "HEAL");
        cardPanel.add(gameOverPanel, "GAME OVER");
        cardPanel.add(enemyRoomEndPanel,"ENEMY ROOM END" );

        add(cardPanel);
        switchTo("START");
    }
    public void switchTo(String scene){
        if (!scene.equals("START") && !scene.equals("PAUSE") && Game.getInstance().player != null){
            int score = Game.getInstance().player.getPlayerScore();
            fightRoomPanel.setScore(score);
            healRoomPanel.setScore(score);
            roomEndPanel.setScore(score);
            gameOverPanel.setScore(score);
        }
        cardLayout.show(cardPanel, scene);
    }
}