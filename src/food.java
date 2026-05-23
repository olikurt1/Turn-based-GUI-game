public class food extends Healable{
    public food(){
        super(50, 30);
    }

    public void heal(Player player){
        //ensure player health doesn't exceed max health when current health means healing exceeds max health
        if(player.getMaxHealth() - player.getUserHealth() < this.amountToHeal){
            player.setUserHealth(player.getMaxHealth());
        }
        else{
            player.setUserHealth(player.getUserHealth()+this.amountToHeal);
        }
        player.setCoinAmount(player.getCoinAmount()-this.cost);
        
    }
    public int getFoodCost(){
        return cost;
    }
    public int getAmountToHeal(){
        return amountToHeal;
    }
}