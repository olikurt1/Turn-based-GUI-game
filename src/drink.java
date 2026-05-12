public class drink extends Healable{
    public drink(){
        super(15, 10);
    }

    public void heal(Player player){
        if(player.getCoinAmount() < this.cost){
            System.out.println("Insufficient Funds for healable");
        }
        else{
            player.setUserHealth(player.getUserHealth()+this.amountToHeal);
        }
        
    }
    public int getDrinkCost(){
        return cost;
    }
    public int getAmountToHeal(){
        return amountToHeal;
    }
    
}