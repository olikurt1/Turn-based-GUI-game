import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    private CardLayout cardLayout = new CardLayout();
    public JPanel cardPanel =  new JPanel(cardLayout);

    //singleton
    public static GameWindow instance = null;

    private FightRoomPanel fightRoomPanel = new FightRoomPanel();
    private HealRoomPanel healRoomPanel = new HealRoomPanel();
    private RoomEndGUI roomEndPanel = new RoomEndGUI();
    private GameOverPanel gameOverPanel = new GameOverPanel();

    public GameWindow(){
        instance = this;
        setTitle("AI Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardPanel.add(new startMenuGUI(), "START");
        cardPanel.add(new PauseMenuGUI(), "PAUSE");
        cardPanel.add(roomEndPanel, "ROOM END");
        cardPanel.add(fightRoomPanel, "FIGHT");
        cardPanel.add(healRoomPanel, "HEAL");
        cardPanel.add(gameOverPanel, "GAME OVER");

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