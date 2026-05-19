public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60,0);
    }
    //chance of damaging player and returning into message label, same for all enemy types
    public String attack(Player player){
        int chanceOfAttack = (int)(Math.random()*2);
        switch(chanceOfAttack){
            case 0 -> {
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                return this.name+" attacked you with a "+this.enemyWeapon.getWeaponType()+" for "+String.format("%.1f", damagePlacehold)+" damage.";
            }
            case 1 -> { return this.name+" missed, take your chance!!!"; }
        }
        //base case
        return "";
    }
}