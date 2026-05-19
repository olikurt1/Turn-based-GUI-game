public class aiDrone extends Enemy{
    public aiDrone(){
        super("Drone", 15, 0);

    }
    public String attack(Player player){
        int chanceOfAttack = (int)(Math.random()*2);
        switch(chanceOfAttack){
            case 0 -> {
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                return this.name+" attacked you with a "+this.enemyWeapon.getWeaponType()+" for "+String.format("%.1f", damagePlacehold);
            }
            case 1 -> { return this.name+" missed, take your chance!!!"; }
        }
        return "";
    }
}