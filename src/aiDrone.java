public class aiDrone extends Enemy{
    public aiDrone(){
        super("Drone", 15, 10);

    }
    public void attack(Player player){
        player.setUserHealth((int)(player.getUserHealth()-baseDamage));
        System.out.printf("Drone has attacked you for %f damage\n", baseDamage);
    }
}