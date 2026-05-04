public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30, 15);
    }
    public void attack(Player player){
        System.out.println(" /\\ ");
        System.out.println("[::]");
        System.out.println("/||\\");
        System.out.println(" /\\ ");
        player.setUserHealth((int)(player.getUserHealth()-baseDamage));
        System.out.printf("Solider attacked you dealing %f damage.\n", baseDamage);
    }
}