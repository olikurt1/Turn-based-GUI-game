import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel{
    public GameOverPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel label = new JLabel("GAME OVER");
        label.setFont(new Font("Monospaced", Font.BOLD, 24));
        label.setForeground(Color.RED);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton menuButton = new JButton("MAIN MENU");
        menuButton.setFont(new Font("Monospaced", Font.BOLD, 14));
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
}