public abstract class Enemy{
    protected String name;
    protected double health;
    protected double baseDamage;
    protected Weapon enemyWeapon;
    

    public Enemy(String name, double health, double baseDamage){
        int difficulty = Game.getInstance().getDifficulty();
        this.enemyWeapon = WeaponFactory.createWeapon();
        this.name = name;
        switch(difficulty){
            case 1 ->{
                this.health = health*0.7;
                this.baseDamage = enemyWeapon.getDamage()*0.7;
            }
            case 2 ->{
                this.health = health*1.2;
                this.baseDamage = enemyWeapon.getDamage()*1.2;
            }
            case 3 ->{
                this.health = health*1.7;
                this.baseDamage = enemyWeapon.getDamage()*1.7;
            }
        }
        
    }

    public abstract void attack(Player player);

    public String getName(){
        return name;
    }

    public Weapon getEnemyWeapon(){
        return enemyWeapon;
    }

    public double getEnemyHealth(){
        return health;
    }
    public void setEnemyHealth(double health){
        this.health = health;
    }
}

