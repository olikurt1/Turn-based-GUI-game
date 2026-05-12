public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30, 0);
    }
    public void attack(Player player){
        System.out.println(" /\\ ");
        System.out.println("[::]");
        System.out.println("/||\\");
        System.out.println(" /\\ ");
        player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
        System.out.printf("Soldier attacked you for %s damage!!!\n", damagePlacehold);
    }
}