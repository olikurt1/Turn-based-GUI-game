public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60,0);
    }
    public void attack(Player player){
        int chanceOfAttack = (int)(Math.random()*2);
        System.out.println(" /==\\");
        System.out.println("|:[]:|");
        System.out.println("|/||\\|");
        System.out.println(" /||\\ ");
        System.out.println(" /  \\");
        switch(chanceOfAttack){
            case 0 ->{
                player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
                System.out.printf(this.name+" attacked you with a %s for %.1f damage.\n", this.enemyWeapon.getWeaponType(), damagePlacehold);
            }
            case 1 ->{
                System.out.println(this.name+" missed, take your chance!!!");
            }
        }

        
    }
}