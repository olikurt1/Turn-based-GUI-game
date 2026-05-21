public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60,0);
    }
    //chance of damaging player and returning into message label, same for all enemy types
    public String attack(Player player){
        int chanceOfAttack = (int)(Math.random()*10);
        switch(chanceOfAttack){
            //80% chance of attack
            case 0, 2, 3, 4, 5, 6, 7, 9 -> {
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                return this.name+" attacked you with a "+this.enemyWeapon.getWeaponType()+" for "+String.format("%.0f", damagePlacehold);
            }
            case 1, 8 -> { 
                return this.name+" missed, take your chance!!!"; 
            }
        }
        //base case
        return "";
    }
}