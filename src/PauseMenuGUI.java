import javax.swing.*;
import java.awt.*;


public class PauseMenuGUI extends JPanel{
    private static PauseMenuGUI instance = null;

    public static PauseMenuGUI getInstance(){
        if(instance == null){
            instance = new PauseMenuGUI();
        }
        return instance;
    }
    protected PauseMenuGUI(){


        //creating window overlay
        JPanel pausePanel = new JPanel();
        pausePanel.setLayout(new BoxLayout(pausePanel, BoxLayout.Y_AXIS));
        pausePanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        pausePanel.setBackground(Color.BLACK);

        //Pause Menu Title
        JLabel titleLabel = new JLabel("PAUSE MENU");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //button "class"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.BLACK);

        JButton resumeButton = new JButton("RESUME");
        resumeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        resumeButton.setBackground(new Color(0, 150, 0));
        resumeButton.setForeground(Color.WHITE);
        resumeButton.setFocusPainted(false);
        resumeButton.setOpaque(true);
        resumeButton.setBorderPainted(false);

        JButton quitButton = new JButton("QUIT");
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        quitButton.setBackground(new Color(150, 0, 0));
        quitButton.setForeground(Color.WHITE);
        quitButton.setFocusPainted(false);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);

        resumeButton.addActionListener(e -> {
            GameWindow.instance.switchTo("ROOM END");
        });

        quitButton.addActionListener(e -> {
            GameWindow.instance.switchTo("START");
        });

        buttonPanel.add(resumeButton);
        buttonPanel.add(quitButton);

        pausePanel.add(titleLabel);
        pausePanel.add(Box.createVerticalStrut(30));
        pausePanel.add(buttonPanel);

        setLayout(new BorderLayout());
        add(pausePanel, BorderLayout.CENTER);
    }
}