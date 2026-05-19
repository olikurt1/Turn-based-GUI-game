 import javax.swing.*;
import java.awt.*;

public class FightRoomPanel extends JPanel{
    private JLabel enemyLabel = new JLabel();
    private JLabel enemyHpLabel = new JLabel();
    private JLabel CoinLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private Enemy currentEnemy;
    private JLabel scoreLabel = new JLabel("Score: 0");
    private JLabel healthLabel = new JLabel("HP: -");
    private JLabel enemyImageLabel = new JLabel();
    private JLabel playerImageLabel = new JLabel();
    //stores the actual images as attributes to be rescaled with 
    private Image playerRawImage;
    private Image enemyRawImage;
    //constructor
    public FightRoomPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //placing enemy image on the left 
        add(enemyImageLabel, BorderLayout.WEST);

        //player image on right
        playerRawImage = new ImageIcon(getClass().getClassLoader().getResource("player.png")).getImage();
        add(playerImageLabel, BorderLayout.EAST);

        //function using existing component listener from awt library but overriding resizing method with custom rescaleImages function
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                rescaleImages();
            }
        });

        //center panel for buttons and messages
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));
        centrePanel.setBackground(Color.BLACK);

        Font hudFont = new Font("SansSerif", Font.BOLD, 13);
        healthLabel.setFont(hudFont);
        healthLabel.setForeground(Color.CYAN);
        scoreLabel.setFont(hudFont);
        scoreLabel.setForeground(Color.CYAN);
        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setBackground(Color.BLACK);
        topRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        topRow.add(healthLabel, BorderLayout.WEST);
        topRow.add(scoreLabel, BorderLayout.EAST);
        centrePanel.add(topRow);
        centrePanel.add(Box.createVerticalStrut(10));

        for(JLabel label : new JLabel[]{enemyLabel, enemyHpLabel, CoinLabel, messageLabel}){
            label.setForeground(Color.CYAN);
            label.setFont(new Font("SansSerif", Font.BOLD, 14));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            centrePanel.add(label);
            centrePanel.add(Box.createVerticalStrut(10));
        }
        JButton attackButton = new JButton("ATTACK");
        JButton dodgeButton = new JButton("DODGE");
        styleButton(attackButton, new Color(0, 150, 0));
        styleButton(dodgeButton, new Color(0, 0, 150));

        attackButton.addActionListener(e -> takeTurn(new AttackAction()));
        dodgeButton.addActionListener(e -> takeTurn(new DodgeAction()));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(attackButton);
        buttonPanel.add(dodgeButton);
        centrePanel.add(buttonPanel);

        add(centrePanel, BorderLayout.CENTER);
    }
    public void setScore(int score){ scoreLabel.setText("Score: " + score); }

    public void loadRoom(FightRoom room){
        currentEnemy = EnemyFactory.createEnemy();
        messageLabel.setText("");
        healthLabel.setText("HP: " + Game.getInstance().player.getUserHealth());
        refresh();

        String imageName = switch(currentEnemy.getName()){
            case "Drone" -> "aiDrone.png";
            case "Soldier" -> "aiSolider.png";
            case "Commander" -> "aiCommander.png";
            default -> null;
        };
        if(imageName != null){
            enemyRawImage = new ImageIcon(getClass().getClassLoader().getResource(imageName)).getImage();
            rescaleImages();
        }
    }
    
    private void takeTurn(CombatAction action){
        Player player = Game.getInstance().player;
        String playerMsg = action.execute(player, currentEnemy);

        if(currentEnemy.getEnemyHealth() <= 0){
            switch(currentEnemy.getName()){
                case "Drone" -> player.setCoinAmount(player.getCoinAmount() + 5);
                case "Soldier" -> player.setCoinAmount(player.getCoinAmount() + 10);
                case "Commander" -> player.setCoinAmount(player.getCoinAmount() + 20);
            }
            GameWindow.instance.switchTo("ENEMY ROOM END");
            return;
        }

        String enemyMsg = currentEnemy.attack(player);
        messageLabel.setText(playerMsg);
        //Thread.sleep but for swing ui to ensure messages are seen
        javax.swing.Timer timer = new javax.swing.Timer(1000, e ->{
            messageLabel.setText(enemyMsg);
        });
        timer.setRepeats(false);
        timer.start();
        

        if (player.getUserHealth() <= 0){
            GameWindow.instance.switchTo("GAME OVER");
            return;
        }

        refresh();
    }
    //updates the stats shown on screen after each turn
    private void refresh(){
        Player player = Game.getInstance().player;
        enemyLabel.setText("Enemy: "+ currentEnemy.getName());
        enemyHpLabel.setText("Enemy HP: "+ currentEnemy.getEnemyHealth());
        CoinLabel.setText("Coins: "+player.getCoinAmount());
        healthLabel.setText("HP: " + player.getUserHealth());
    }
    //function to change image size
    private void rescaleImages(){
        //fixed size for images which is set to be relative to window size
        int size = Math.max(50, getHeight() / 3);
        if(playerRawImage != null)
            playerImageLabel.setIcon(new ImageIcon(playerRawImage.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        if(enemyRawImage != null)
            enemyImageLabel.setIcon(new ImageIcon(enemyRawImage.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
    }
    private void styleButton(JButton button, Color background){
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
}