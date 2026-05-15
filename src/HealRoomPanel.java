import javax.swing.*;
import java.awt.*;

public class HealRoomPanel extends JPanel{
    private JLabel statusLabel= new JLabel();

    public HealRoomPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("HEAL ROOM");
        title.setFont(new Font("Monospaced", Font.BOLD, 18));
        title.setForeground(Color.CYAN);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton foodButton = new JButton("BUY FOOD (50 HP / 30 coins)");
        JButton drinkButton = new JButton("Buy DRINK(15 HP / 10 coins)");
        JButton continueButton = new JButton("CONTINUE");

        for(JButton button : new JButton[]{foodButton, drinkButton, continueButton}){
            button.setFont(new Font("Monospaced", Font.BOLD, 13));
            button.setBackground(Color.CYAN);
            button.setForeground(Color.BLUE);
            button.setFocusPainted(false);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
        foodButton.addActionListener(e -> {
            Player player = Game.getInstance().player;
            food f = new food();
            if(player.getCoinAmount() < f.getFoodCost()){
                statusLabel.setText("Not enough coins for food");
            }
            else{
                f.heal(player);
                statusLabel.setText("You ate food. HP: "+ player.getUserHealth());
            }
        });
        drinkButton.addActionListener(e -> {
            Player player = Game.getInstance().player;
            drink d = new drink();
            if(player.getCoinAmount() < d.getDrinkCost()){
                statusLabel.setText("Not enough coins for drink");
            }
            else{
                d.heal(player);
                    statusLabel.setText("You drank. HP: "+player.getUserHealth());  
            }
        });
        continueButton.addActionListener(e -> GameWindow.instance.switchTo("ROOM END"));

        add(title);
        add(Box.createVerticalStrut(20));
        add(statusLabel);
        add(Box.createVerticalStrut(15));
        add(foodButton);
        add(Box.createVerticalStrut(10));
        add(drinkButton);
        add(Box.createVerticalStrut(10));
        add(continueButton);
    }

    public void loadRoom(HealRoom room){
        Player player = Game.getInstance().player;
        statusLabel.setText("HP: "+ player.getUserHealth() + " | Coins: "+ player.getCoinAmount());
    }

}