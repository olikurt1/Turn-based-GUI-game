import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    private JLabel weaponLabel = new JLabel("Weapon: -");
    private JLabel weaponDamageLabel = new JLabel("Damage: -");
    private JLabel foodLabel = new JLabel("Food: 0");
    private JLabel drinkLabel = new JLabel("Drink: 0");
    private JLabel coinsLabel = new JLabel("Coins: 0");
    private JLabel messageLabel = new JLabel();

    public InventoryPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel title = new JLabel("INVENTORY");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(Color.CYAN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        //rendering the labels one after another using loop since their the same object types
        for (JLabel label : new JLabel[]{weaponLabel, weaponDamageLabel, foodLabel, drinkLabel, coinsLabel, messageLabel}) {
            label.setFont(new Font("SansSerif", Font.PLAIN, 20));
            label.setForeground(Color.CYAN);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        //button that returns player to scene previous to inventory
        JButton returnButton = new JButton("RETURN TO ROOM");
        styleButton(returnButton);
        JButton FoodButton = new JButton("USE FOOD");
        styleButton(FoodButton);
        JButton DrinkButton = new JButton("USE DRINK");
        styleButton(DrinkButton);

        returnButton.addActionListener(e -> {
            String previousScene = GameWindow.instance.getPreviousScene();
            if (previousScene != null) {
                GameWindow.instance.switchTo(previousScene);
            }
        });
        FoodButton.addActionListener(e -> {
            Player player = Game.getInstance().player;
            if(player.getUserHealth() == player.getMaxHealth()){
                messageLabel.setText("You are full health.");
            }
            else{
                if(player.getFoodCount() > 0){
                    food food = new food();
                    player.setUserHealth(player.getUserHealth()+food.amountToHeal);
                    player.setFoodCount(player.getFoodCount()-1);
                }
                else{
                    messageLabel.setText("You haven't got enough food.");
                }
            }
            refresh(player);
        });
        DrinkButton.addActionListener(e -> {
            Player player = Game.getInstance().player;
            if(player.getUserHealth() == player.getMaxHealth()){
                messageLabel.setText("You are full health");
            }
            else{
                if(player.getDrinkCount()>0){
                    drink drink = new drink();
                    player.setUserHealth(player.getUserHealth()+drink.amountToHeal);
                    player.setDrinkCount(player.getDrinkCount()-1);
                }
            else{
                messageLabel.setText("You haven't got enough drink");
                }
            }

            refresh(player);
        });

        //forming scene with all initialised attributes
        add(title);
        add(Box.createVerticalStrut(15));
        add(weaponLabel);
        add(Box.createVerticalStrut(5));
        add(weaponDamageLabel);
        add(Box.createVerticalStrut(15));
        add(foodLabel);
        add(Box.createVerticalStrut(5));
        add(drinkLabel);
        add(Box.createVerticalStrut(15));
        add(coinsLabel);
        add(Box.createVerticalStrut(10));
        add(messageLabel);
        add(Box.createVerticalStrut(15));
        add(returnButton);
        add(Box.createVerticalStrut(10));
        add(FoodButton);
        add(Box.createVerticalStrut(10));
        add(DrinkButton);
        add(Box.createVerticalGlue());
    }
    //HUD info refreshes constantly to reflect changes
    public void refresh(Player player) {
        Weapon currentWeapon = player.getPlayerWeapon();
        //ternary operators check for null weapon type
        weaponLabel.setText("Weapon: " + (currentWeapon != null ? currentWeapon.getWeaponType() : "None"));
        weaponDamageLabel.setText("Damage: " + (currentWeapon != null ? currentWeapon.getDamage() : 0));
        coinsLabel.setText("Coins: " + player.getCoinAmount());
        foodLabel.setText("Food: " + player.getFoodCount());
        drinkLabel.setText("Drink: " + player.getDrinkCount());
    }

    public void setFoodCount(int count) {
        foodLabel.setText("Food: " + count);
    }

    public void setDrinkCount(int count) {
        drinkLabel.setText("Drink: " + count);
    }
    private void styleButton(JButton button){
        button.setBackground(Color.CYAN);
        button.setForeground(Color.BLUE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
