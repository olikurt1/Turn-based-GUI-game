import javax.swing.*;
import java.awt.*;


public class RoomEndGUI extends JPanel{
    private JLabel scoreLabel = new JLabel("Score: 0");

    protected RoomEndGUI(){


        JPanel endPanel = new JPanel();
        endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
        endPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        endPanel.setBackground(Color.BLACK);

        JLabel endLabel = new JLabel("YOU HAVE EXITED THE ROOM CHOOSE WHAT TO DO NEXT");
        endLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        endLabel.setForeground(Color.CYAN);
        endLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0 ));
        buttonPanel.setBackground(Color.BLACK);

        JButton continueButton = new JButton("CONTINUE");
        continueButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        continueButton.setBackground(Color.CYAN);
        continueButton.setForeground(Color.BLUE);
        continueButton.setFocusPainted(false);
        continueButton.setOpaque(true);
        continueButton.setBorderPainted(false);

        JButton pauseButton = new JButton("PAUSE");
        pauseButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        pauseButton.setBackground(Color.CYAN);
        pauseButton.setForeground(Color.BLUE);
        pauseButton.setFocusPainted(false);
        pauseButton.setOpaque(true);
        pauseButton.setBorderPainted(false);

        continueButton.addActionListener(e -> {
            Game.getInstance().startNextRoom();
        });
        pauseButton.addActionListener(e -> {
            GameWindow.instance.switchTo("PAUSE");
        });

        buttonPanel.add(continueButton);
        buttonPanel.add(pauseButton);

        endPanel.add(endLabel);
        endPanel.add(Box.createVerticalStrut(30));
        endPanel.add(buttonPanel);

        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        scoreLabel.setForeground(Color.CYAN);
        scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.setBackground(Color.BLACK);
        northPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 10));
        northPanel.add(scoreLabel, BorderLayout.EAST);

        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(endPanel, BorderLayout.CENTER);
    }

    public void setScore(int score){ scoreLabel.setText("Score: " + score); }
}