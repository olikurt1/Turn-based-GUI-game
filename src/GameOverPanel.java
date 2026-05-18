import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel{
    private JLabel scoreLabel = new JLabel("Score: 0");

    public GameOverPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        scoreLabel.setForeground(Color.CYAN);
        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setBackground(Color.BLACK);
        topRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        topRow.add(scoreLabel, BorderLayout.EAST);
        add(topRow);
        add(Box.createVerticalStrut(10));

        JLabel label = new JLabel("GAME OVER");
        label.setFont(new Font("SansSerif", Font.BOLD, 24));
        label.setForeground(Color.RED);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("MAIN MENU");
        menuButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        menuButton.setBackground(Color.RED);
        menuButton.setForeground(Color.WHITE);
        menuButton.setFocusPainted(false);
        menuButton.setOpaque(true);
        menuButton.setBorderPainted(false);
        menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuButton.addActionListener(e -> GameWindow.instance.switchTo("START"));

        add(label);

        add(Box.createVerticalStrut(30));
        add(menuButton);
    }

    public void setScore(int score){ 
        scoreLabel.setText("Score: " + score); 
    }
}