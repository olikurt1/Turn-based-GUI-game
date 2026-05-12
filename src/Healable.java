public abstract class Healable{
    protected int amountToHeal;
    protected int cost;

    public Healable(int amountToHeal, int cost){
        this.amountToHeal = amountToHeal;
        this.cost = cost;
    }

    public abstract void heal(Player player);
}