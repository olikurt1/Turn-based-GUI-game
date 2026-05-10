public abstract class Enemy{
    protected String name;
    protected double health;
    protected double damagePlacehold;
    protected Weapon enemyWeapon;
    

    public Enemy(String name, double health, double damagePlacehold){
        int difficulty = Game.getInstance().getDifficulty();
        this.enemyWeapon = WeaponFactory.createWeapon();
        this.name = name;
        switch(difficulty){
            case 1 ->{
                this.health = health*0.5;
                this.damagePlacehold = enemyWeapon.getDamage()*0.5;
            }
            case 2 ->{
                this.health = health;
                this.damagePlacehold = enemyWeapon.getDamage();
            }
            case 3 ->{
                this.health = health*1.5;
                this.damagePlacehold = enemyWeapon.getDamage()*1.5;
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

