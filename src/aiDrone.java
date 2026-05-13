public class aiDrone extends Enemy{
    public aiDrone(){
        super("Drone", 15, 0);

    }
    public void attack(Player player){
        int chanceOfAttack = (int)(Math.random()*2);
        System.out.println("<>");
        System.out.println("/\\");
        switch(chanceOfAttack){
            case 0 -> {
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                System.out.printf(this.name+" has attacked you with a %s for %f damage.\n", this.enemyWeapon, damagePlacehold);
            }
            case 1 -> {
                System.out.println(this.name+" missed, take your chance!!!");
            }
        }

    }
}