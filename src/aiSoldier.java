public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30);
    }
    public void attack(Player player){
        player.setUserHealth(player.getUserHealth()-15);
        System.out.println("Solider attacked you dealing 15 damage.");
    }
}