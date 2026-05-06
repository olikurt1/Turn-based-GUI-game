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
    }
}