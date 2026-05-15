import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame{
    private CardLayout cardLayout = new CardLayout();
    public JPanel cardPanel =  new JPanel(cardLayout);

    //singleton 
    public static GameWindow instance = null;

    public static GameWindow getInstance(){
        if(instance == null){
            instance = new GameWindow();
        }
        return instance;
    }
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

        add(cardPanel);
        switchTo("START");
    }
    public void switchTo(String scene){
        cardLayout.show(cardPanel, scene);
    }
}