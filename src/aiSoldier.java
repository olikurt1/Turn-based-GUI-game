public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30, 15);
    }
    public void attack(Player player){
        player.setUserHealth((int)(player.getUserHealth()-baseDamage));
        System.out.printf("Solider attacked you dealing %f damage\n.", baseDamage);
    }
}