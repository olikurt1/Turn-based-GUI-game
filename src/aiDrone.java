public class aiDrone extends Enemy{
    public aiDrone(){
        super("Drone", 15, 0);

    }
    public void attack(Player player){
        System.out.println("<>");
        System.out.println("/\\");
        player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
        System.out.printf("Drone has attacked you with a %s for %f damage.\n", this.enemyWeapon, damagePlacehold);
    }
}