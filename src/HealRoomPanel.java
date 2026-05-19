import javax.swing.*;
import java.awt.*;

public class HealRoomPanel extends JPanel{
    private JLabel statusLabel= new JLabel();
    private JLabel scoreLabel = new JLabel("Score: 0");
    private Image drinkRawImage;
    private Image foodRawImage;
    private JLabel drinkImageLabel = new JLabel();
    private JLabel foodImageLabel = new JLabel();

    public HealRoomPanel(){
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //declaring the images for healables
        drinkRawImage = new ImageIcon(getClass().getClassLoader().getResource("drink.png")).getImage();
        foodRawImage = new ImageIcon(getClass().getClassLoader().getResource("food.png")).getImage();
        //listener for images to resize dynamically with window
        addComponentListener(new java.awt.event.ComponentAdapter(){
            @Override
            public void componentResized(java.awt.event.ComponentEvent e){
                rescaleImages();
            }
        });

        scoreLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        scoreLabel.setForeground(Color.CYAN);
        JPanel topRow = new JPanel(new BorderLayout());
        topRow.setBackground(Color.BLACK);
        topRow.add(scoreLabel, BorderLayout.EAST);
        add(topRow, BorderLayout.NORTH);

        JLabel title = new JLabel("HEAL ROOM");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setForeground(Color.CYAN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusLabel.setForeground(Color.CYAN);
        
        JButton foodButton = new JButton("BUY FOOD (50 HP / 30 coins)");
        JButton drinkButton = new JButton("Buy DRINK(15 HP / 10 coins)");
        JButton continueButton = new JButton("CONTINUE");
        
        //setting buttons as a for loop so does one at at a time 
        for(JButton button : new JButton[]{foodButton, drinkButton, continueButton}){
            button.setFont(new Font("SansSerif", Font.BOLD, 13));
            button.setBackground(Color.CYAN);
            button.setForeground(Color.BLUE);
            button.setFocusPainted(false);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        //creating button functionality for food, drink and continuing buttons
        foodButton.addActionListener(e -> {
            Player player = Game.getInstance().player;
            food f = new food();
            if(player.getUserHealth() == player.getMaxHealth()){
                statusLabel.setText("You are full health already");
            }
            else if(player.getCoinAmount() < f.getFoodCost()){
                statusLabel.setText("Not enough coins!");
            }
            else{
                f.heal(player);
                statusLabel.setText("You ate food. HP: "+ player.getUserHealth());
            }
        });
        drinkButton.addActionListener(e -> {
            Player player = Game.getInstance().player;
            drink d = new drink();
            if(player.getUserHealth() == player.getMaxHealth()){
                statusLabel.setText("You are full health already!");
            }
            else if(player.getCoinAmount() < d.getDrinkCost()){
                statusLabel.setText("Not enough coins for drink!");
            }
            else{
                d.heal(player);
                statusLabel.setText("You drank. HP: "+player.getUserHealth());  
            }
        });
        continueButton.addActionListener(e -> GameWindow.instance.switchTo("ROOM END"));
        //center panel for button HUD
        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BoxLayout(centrePanel, BoxLayout.Y_AXIS));

        centrePanel.setBackground(Color.BLACK);
        centrePanel.add(Box.createVerticalGlue());
        centrePanel.add(title);
        centrePanel.add(Box.createVerticalStrut(20));
        centrePanel.add(statusLabel);
        centrePanel.add(Box.createVerticalStrut(15));
        centrePanel.add(foodButton);
        centrePanel.add(Box.createVerticalStrut(10));
        centrePanel.add(drinkButton);
        centrePanel.add(Box.createVerticalStrut(10));
        centrePanel.add(continueButton);
        centrePanel.add(Box.createVerticalGlue());

        add(centrePanel, BorderLayout.CENTER);
        //vertical strut creates a vertical gap between each label/button
        add(drinkImageLabel, BorderLayout.WEST);
        add(foodImageLabel, BorderLayout.EAST);
    }

    public void setScore(int score){ 
        scoreLabel.setText("Score: " + score); 
    }

    public void loadRoom(HealRoom room){
        Player player = Game.getInstance().player;
        statusLabel.setText("HP: "+ player.getUserHealth() + " | Coins: "+ player.getCoinAmount());
    }

    //function to change image size
    private void rescaleImages(){
        //fixed size for images which is set to be relative to window size
        int size = Math.max(50, getHeight() / 3);
        if(drinkRawImage != null)
            drinkImageLabel.setIcon(new ImageIcon(drinkRawImage.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        if(foodRawImage != null)
            foodImageLabel.setIcon(new ImageIcon(foodRawImage.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
    }

}