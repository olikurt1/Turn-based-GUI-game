public class FightRoom extends Room{
    
    public FightRoom(){
        super("Fight Room");
        
    }
    
    public void playerEnter(Player player){
        Enemy currentEnemy = EnemyFactory.createEnemy();    
        currentEnemy.attack(player);
        player.playerChoiceFight(currentEnemy);
    }
}