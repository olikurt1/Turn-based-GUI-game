public class drink extends Healable{
    public drink(){
        super(15, 10);
    }

    public void heal(Player player){
        player.setUserHealth(player.getUserHealth()+this.amountToHeal);
        player.setCoinAmount(player.getCoinAmount()-this.cost);  
    }
    public int getDrinkCost(){
        return cost;
    }
    public int getAmountToHeal(){
        return amountToHeal;
    }
    
}