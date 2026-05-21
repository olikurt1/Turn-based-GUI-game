public class aiDrone extends Enemy{
    public aiDrone(){
        super("Drone", 15, 0);

    }
    public String attack(Player player){
        int chanceOfAttack = (int)(Math.random()*10);
        switch(chanceOfAttack){
            //40% Chance of attack
            case 0, 2, 4, 6 -> {
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                return this.name+" attacked you with a "+this.enemyWeapon.getWeaponType()+" for "+String.format("%.0f", damagePlacehold);
            }
            case 1, 3, 5, 7, 8, 9 -> { 
                return this.name+" missed, take your chance!!!"; 
            }
        }
        return "";
    }
}