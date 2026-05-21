public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30, 0);
    }
    public String attack(Player player){
        int chanceOfAttack = (int)(Math.random()*10);
        switch(chanceOfAttack){
            //60% chance of attack
            case 0, 2, 4, 6, 7, 8 -> {
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                return this.name+" attacked you with a "+this.enemyWeapon.getWeaponType()+" for "+String.format("%.0f", damagePlacehold);
            }
            case 1, 3, 5, 9 -> { 
                return this.name+" missed, take your chance!!!"; 
            }
        }
        //base case
        return "";
    }
}