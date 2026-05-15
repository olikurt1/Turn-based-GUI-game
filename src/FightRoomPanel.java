import javax.swing.*;
import java.awt.*;

public class FightRoomPanel extends JPanel{
    private JLabel enemyLabel = new JLabel();
    private JLabel enemyHpLabel = new JLabel();
    private JLabel playerHpLabel = new JLabel();
    private JLabel messageLabel = new JLabel();
    private Enemy currentEnemy;

    public FightRoomPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(30, 30, 30));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        for(JLabel label : new JLabel[]{enemyLabel, enemyHpLabel, playerHpLabel, messageLabel}){
            label.setForeground(Color.CYAN);
            label.setFont(new Font("Monospaced", Font.PLAIN, 14));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(label);
            add(Box.createVerticalStrut(10));
        }
        JButton attackButton = new JButton("ATTACK");
        JButton dodgeButton = new JButton("DODGE");
        styleButton(attackButton, new Color(0, 150, 0));
        styleButton(dodgeButton, new Color(0, 0, 150));

        attackButton.addActionListener(e -> takeTurn(new AttackAction()));
        dodgeButton.addActionListener(e -> takeTurn(new DodgeAction()));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(new Color(30, 30, 30));
        buttonPanel.add(attackButton);
        buttonPanel.add(dodgeButton);
        add(buttonPanel);
    }
    public void loadRoom(FightRoom room){
        currentEnemy= EnemyFactory.createEnemy();
        refresh();
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
            GameWindow.instance.switchTo("ROOM END");
            return;
        }

        String enemyMsg = currentEnemy.attack(player);
        messageLabel.setText(playerMsg + " | " + enemyMsg);

        if (player.getUserHealth() <= 0){
            GameWindow.instance.switchTo("GAME OVER");
            return;
        }

        refresh();
    }

    private void refresh(){
        Player player = Game.getInstance().player;
        enemyLabel.setText("Enemy: "+ currentEnemy.getName());
        enemyHpLabel.setText("Enemy HP: "+ currentEnemy.getEnemyHealth());
        playerHpLabel.setText("Player HP: "+ player.getUserHealth()+ " | Coins: "+player.getCoinAmount());

    }
    private void styleButton(JButton button, Color background){
        button.setFont(new Font("Monospaced", Font.BOLD, 14));
        button.setBackground(background);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorderPainted(false);
    }
}