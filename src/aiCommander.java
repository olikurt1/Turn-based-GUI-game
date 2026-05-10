public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60,0);
    }
    public void attack(Player player){
        System.out.println(" /==\\");
        System.out.println("|:[]:|");
        System.out.println("|/||\\|");
        System.out.println(" /||\\ ");
        System.out.println(" /  \\");
        player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
        System.out.printf("Commander attacked you for %f damage.\n", damagePlacehold);
        
    }
}