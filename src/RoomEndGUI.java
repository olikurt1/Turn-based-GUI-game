import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class RoomEndGUI extends JFrame{
    private RoomEndGUI(CountDownLatch latch){
        setTitle("Room End");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel endPanel = new JPanel();
        endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
        endPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        endPanel.setBackground(new Color(30, 30, 30));

        JLabel endLabel = new JLabel("YOU HAVE EXITED THE ROOM CHOOSE WHAT TO DO NEXT");
        endLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        endLabel.setForeground(Color.CYAN);
        endLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0 ));
        buttonPanel.setBackground(new Color(30, 30, 30));

        JButton continueButton = new JButton("CONTINUE");
        continueButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        continueButton.setBackground(Color.CYAN);
        continueButton.setForeground(Color.BLUE);
        continueButton.setFocusPainted(false);
        continueButton.setOpaque(true);
        continueButton.setBorderPainted(false);

        JButton pauseButton = new JButton("PAUSE");
        pauseButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        pauseButton.setBackground(Color.CYAN);
        pauseButton.setForeground(Color.BLUE);
        pauseButton.setFocusPainted(false);
        pauseButton.setOpaque(true);
        pauseButton.setBorderPainted(false);

        continueButton.addActionListener(e -> {
            dispose();
            latch.countDown();
        });
        pauseButton.addActionListener(e -> {
            dispose();
            PauseMenuGUI.display();
        });

        buttonPanel.add(continueButton);
        buttonPanel.add(pauseButton);

        endPanel.add(endLabel);
        endPanel.add(Box.createVerticalStrut(30));
        endPanel.add(buttonPanel);

        add(endPanel);
    }

    public static void display(){
        CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            RoomEndGUI endGUI = new RoomEndGUI(latch);
            endGUI.setVisible(true);
        });

        try{
            latch.await();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}