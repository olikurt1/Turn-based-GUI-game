import java.util.Scanner;
public class FightRoom extends Room{
    
    public FightRoom(){
        super("Fight Room");
        
    }
    
    public void playerEnter(Player player, Scanner input){
        Enemy currentEnemy = EnemyFactory.createEnemy();    
        while(currentEnemy.getEnemyHealth()>0){
            player.playerChoiceFight(currentEnemy, input);
            currentEnemy.attack(player);
        } 
        System.out.println("You have defeated the enemy!!");
        switch(currentEnemy.getName()){
            case "Drone" -> {
                player.setCoinAmount(player.getCoinAmount()+5);
                System.out.println("You have received 5 coins.");
            }
            case "Solider" -> {
                player.setCoinAmount(player.getCoinAmount()+10);
                System.out.println("You have received 10 coins.");
            }
            case "Commander" -> {
                player.setCoinAmount(player.getCoinAmount()+20);
                System.out.println("You have received 20 coins.");
            }
        } 
    }
}