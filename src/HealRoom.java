public class HealRoom extends Room{
    public HealRoom(){
        super("Heal Room");
    }
    public void playerEnter(Player player){
        if(player.getUserHealth()==100){
            System.out.println("You are full health.");
        }
        else{
            player.setUserHealth(player.getUserHealth()+(100-player.getUserHealth()));
            System.out.println("You are full health again!!");  
        }  
    }
}