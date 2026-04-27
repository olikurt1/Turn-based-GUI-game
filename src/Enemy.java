public abstract class Enemy{
    protected String name;
    protected double health;
    protected double baseDamage;
    

    public Enemy(String name, double health, double baseDamage){
        int difficulty = Game.getInstance().getDifficulty();
        this.name = name;
        switch(difficulty){
            case 1 ->{
                this.health = health*0.7;
                this.baseDamage = baseDamage*0.7;
            }
            case 2 ->{
                this.health = health*1.2;
                this.baseDamage = baseDamage*1.2;
            }
            case 3 ->{
                this.health = health*1.7;
                this.baseDamage = baseDamage*1.7;
            }
        }
    }

    public abstract void attack(Player player);

    public String getName(){
        return name;
    }
}

