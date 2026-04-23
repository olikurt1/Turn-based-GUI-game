public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60);
    }
    public void attack(Player player){
        player.setUserHealth(player.getUserHealth()-30);
        System.out.println("Commander attacked you for 30 damage");
        
    }
}