import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;


public class PauseMenuGUI extends JFrame{
    private PauseMenuGUI(CountDownLatch latch){
        //creating window
        setTitle("Pause Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        //creating window overlay
        JPanel pausePanel = new JPanel();
        pausePanel.setLayout(new BoxLayout(pausePanel, BoxLayout.Y_AXIS));
        pausePanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        pausePanel.setBackground(new Color(30, 30, 30));

        //Pause Menu Title
        JLabel titleLabel = new JLabel("PAUSE MENU");
        titleLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //button "class"
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(new Color(30, 30, 30));

        JButton resumeButton = new JButton("RESUME");
        resumeButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        resumeButton.setBackground(new Color(0, 150, 0));
        resumeButton.setForeground(Color.WHITE);
        resumeButton.setFocusPainted(false);
        resumeButton.setOpaque(true);
        resumeButton.setBorderPainted(false);

        JButton quitButton = new JButton("QUIT");
        quitButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        quitButton.setBackground(new Color(150, 0, 0));
        quitButton.setForeground(Color.WHITE);
        quitButton.setFocusPainted(false);
        quitButton.setOpaque(true);
        quitButton.setBorderPainted(false);

        resumeButton.addActionListener(e -> {
            System.out.println("Resuming...");
            dispose();
            latch.countDown();
        });

        quitButton.addActionListener(e -> {
            dispose();
            System.exit(0);
        });

        buttonPanel.add(resumeButton);
        buttonPanel.add(quitButton);

        pausePanel.add(titleLabel);
        pausePanel.add(Box.createVerticalStrut(30));
        pausePanel.add(buttonPanel);

        add(pausePanel);
    }
    //function to actually show menu
    public static void display(){
        //synchronises thread
        CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            //creates a Pause menu instance
            PauseMenuGUI PauseGui = new PauseMenuGUI(latch);
            PauseGui.setVisible(true);
        });
        //ensures exceptions are handled 
        try{
            latch.await();
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}