import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    private CardLayout cardLayout = new CardLayout();
    public JPanel cardPanel =  new JPanel(cardLayout);

    //singleton 
    public static GameWindow instance = null;


    public GameWindow(){
        instance = this;
        setTitle("AI Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        cardPanel.add(new startMenuGUI(), "START");
        cardPanel.add(new PauseMenuGUI(), "PAUSE");
        cardPanel.add(new RoomEndGUI(), "ROOM END");
        cardPanel.add(new FightRoomPanel(), "FIGHT");
        cardPanel.add(new HealRoomPanel(), "HEAL");
        cardPanel.add(new GameOverPanel(), "GAME OVER");

        add(cardPanel);
        switchTo("START");
    }
    public void switchTo(String scene){
        cardLayout.show(cardPanel, scene);
    }
}