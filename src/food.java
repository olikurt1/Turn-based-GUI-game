public class food extends Healable{
    public food(){
        super(50, 30);
    }

    public void heal(Player player){
        if(player.getCoinAmount() < this.cost){
            System.out.println("Insufficient funds for healable.");
        }
        else{
            player.setUserHealth(player.getUserHealth()+ this.amountToHeal);
        }
        
    }
    public int getFoodCost(){
        return cost;
    }
    public int getAmountToHeal(){
        return amountToHeal;
    }
}