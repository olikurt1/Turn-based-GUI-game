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

        add(drinkImageLabel, BorderLayout.WEST);
        add(foodImageLabel, BorderLayout.EAST);
        //declaring the images for healables
        drinkRawImage = new ImageIcon(getClass().getClassLoader().getResource("drink.png")).getImage();
        
        foodRawImage = new ImageIcon(getClass().getClassLoader().getResource("food.png")).getImage();
        
        //listener for images to resize dynamically with window
        addComponentListener(new java.awt.event.ComponentAdapter(){
            //overrides original function to use the custom image rescaling
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
        JButton inventoryButton = new JButton("INVENTORY");
        
        //setting buttons as a for loop so does one at at a time 
        for(JButton button : new JButton[]{foodButton, drinkButton, continueButton, inventoryButton}){
            button.setFont(new Font("SansSerif", Font.BOLD, 13));
            button.setBackground(Color.CYAN);
            button.setForeground(Color.BLUE);
            button.setFocusPainted(false);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        //creating button functionality for food, drink and continuing buttons
        foodButton.addActionListener(e -> showItemDialog(new food()));
        drinkButton.addActionListener(e -> showItemDialog(new drink()));
        continueButton.addActionListener(e -> GameWindow.instance.switchTo("ROOM END"));

        inventoryButton.addActionListener(e -> GameWindow.instance.switchTo("INVENTORY"));
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
        centrePanel.add(Box.createVerticalStrut(10));
        centrePanel.add(inventoryButton);        
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
    //pop up when food or drink button to choose between instant consume or inventory
    private void showItemDialog(Healable item){
        Player player = Game.getInstance().player;
        boolean isFood = item instanceof food;
        String itemName = isFood ? "Food" : "Drink";
        int cost = item.getCost();

        //first checks if there is even enough coins to buy 
        if(player.getCoinAmount() < cost){
            statusLabel.setText("Not enough coins!");
            return;
        }

        String[] options = {"CONSUME", "ADD TO INVENTORY", "CANCEL"};
        //opens pop up to choose what to do with healable purchase
        int choice = JOptionPane.showOptionDialog(
            this,itemName + " costs " + cost + " coins. What would you like to do?",
            itemName.toUpperCase(),
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
        );

        if(choice == 0){
            if(player.getUserHealth() == player.getMaxHealth()){
                statusLabel.setText("Already at full health!");
                return;
            }
            item.heal(player);
            statusLabel.setText("Used " + itemName + ". HP: " + player.getUserHealth());
        } else if(choice == 1){
            player.setCoinAmount(player.getCoinAmount() - cost);
            if(isFood) {
                player.setFoodCount(player.getFoodCount() + 1);
            }
            else{
                player.setDrinkCount(player.getDrinkCount() + 1);
            } 
            statusLabel.setText(itemName + " added to inventory. Coins: " + player.getCoinAmount());
        }
    }

    //function to change image size
    private void rescaleImages(){
        //size for images which is set to be relative to window size
        int size = Math.max(50, getHeight() / 3);
        if(drinkRawImage != null)
            drinkImageLabel.setIcon(new ImageIcon(drinkRawImage.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
        if(foodRawImage != null)
            foodImageLabel.setIcon(new ImageIcon(foodRawImage.getScaledInstance(size, size, Image.SCALE_SMOOTH)));
    }

}