public class food extends Healable{
    public food(){
        super(50, 30);
    }

    public void heal(Player player){
        player.setUserHealth(player.getUserHealth()+ this.amountToHeal);
        player.setCoinAmount(player.getCoinAmount()-this.cost);
        
    }
    public int getFoodCost(){
        return cost;
    }
    public int getAmountToHeal(){
        return amountToHeal;
    }
}