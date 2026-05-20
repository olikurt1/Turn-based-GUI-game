import javax.swing.*;
import java.awt.*;

public class InventoryPanel extends JPanel {
    private JLabel weaponLabel = new JLabel("Weapon: -");
    private JLabel weaponDamageLabel = new JLabel("Damage: -");
    private JLabel foodLabel = new JLabel("Food: 0");
    private JLabel drinkLabel = new JLabel("Drink: 0");
    private JLabel coinsLabel = new JLabel("Coins: 0");

    public InventoryPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel title = new JLabel("INVENTORY");
        title.setFont(new Font("SansSerif", Font.BOLD, 28));
        title.setForeground(Color.CYAN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        //rendering the labels one after another using loop since their the same object types
        for (JLabel label : new JLabel[]{weaponLabel, weaponDamageLabel, foodLabel, drinkLabel, coinsLabel}) {
            label.setFont(new Font("SansSerif", Font.PLAIN, 20));
            label.setForeground(Color.WHITE);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        //button that returns player to scene previous to inventory
        JButton returnButton = new JButton("RETURN TO ROOM");
        returnButton.setBackground(Color.CYAN);
        returnButton.setForeground(Color.BLUE);
        returnButton.setFocusPainted(false);
        returnButton.setOpaque(true);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        returnButton.addActionListener(e -> {
            String previousScene = GameWindow.instance.getPreviousScene();
            if (previousScene != null) {
                GameWindow.instance.switchTo(previousScene);
            }
        });

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
        add(Box.createVerticalStrut(15));
        add(returnButton);
    }
    //HUD info refreshes constantly to reflect changes
    public void refresh(Player player) {
        Weapon currentWeapon = player.getPlayerWeapon();
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
}
