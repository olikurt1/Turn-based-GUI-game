public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60,30);
    }
    public void attack(Player player){
        player.setUserHealth((int)(player.getUserHealth()-baseDamage));
        System.out.printf("Commander attacked you for %f damage\n", baseDamage);
        
    }
}