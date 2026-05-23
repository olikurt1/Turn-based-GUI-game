import javax.swing.*;
import java.awt.*;


public class PauseMenuGUI extends JPanel{
    private JLabel messageLabel = new JLabel();
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


        messageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        messageLabel.setForeground(Color.CYAN);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.BLACK);
        //styling buttons
        JButton resumeButton = new JButton("RESUME");
        styleButton(resumeButton);
        resumeButton.setBackground(new Color(0, 150, 0));
      
        JButton saveButton = new JButton("SAVE PROGRESS");
        styleButton(saveButton);
        saveButton.setBackground(new Color(0, 0, 150));

        JButton quitButton = new JButton("QUIT");
        styleButton(quitButton);
        quitButton.setBackground(new Color(150, 0, 0));

        //providing functionality to the buttons
        resumeButton.addActionListener(e -> {
            String previousScene = GameWindow.instance.getPreviousScene();
            GameWindow.instance.switchTo(previousScene != null ? previousScene : "ROOM END");
        });

        saveButton.addActionListener(e -> {
            SaveManager.save();
            //flashes message instead of leaving it on, also ensures when pause menu loads again the message isn't there until button is pressed again
            messageLabel.setText("You have successfully saved the game data");
            Timer timer = new Timer(1000, f -> {
                messageLabel.setText(" ");
            });
            timer.setRepeats(false);
            timer.start();
        });

        quitButton.addActionListener(e -> {
            GameWindow.instance.switchTo("START");
        });
        //adding labels and panels for buttons and labels
        buttonPanel.add(resumeButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(quitButton);

        pausePanel.add(titleLabel);
        pausePanel.add(Box.createVerticalStrut(15));
        pausePanel.add(messageLabel);
        pausePanel.add(Box.createVerticalStrut(30));
        pausePanel.add(buttonPanel);

        setLayout(new BorderLayout());
        add(pausePanel, BorderLayout.CENTER);
    }
    private void styleButton(JButton button){
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

}