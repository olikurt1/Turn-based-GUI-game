public class aiDrone extends Enemy{
    public aiDrone(){
        super("Drone", 15);

    }
    public void attack(Player player){
        player.setUserHealth(player.getUserHealth()-10);
        System.out.println("Drone has attacked you for 10 damage");
    }
}