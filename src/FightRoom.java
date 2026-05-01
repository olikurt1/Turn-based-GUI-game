public class FightRoom extends Room{
    private Enemy enemy;
    public FightRoom(){
        super("Fight Room");
        this.enemy = EnemyFactory.createEnemy();
    }
    public Enemy getEnemy(){
        return enemy;
    }
    public void playerEnter(Player player){
        
    }
}