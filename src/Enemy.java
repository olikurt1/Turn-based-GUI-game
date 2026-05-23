public abstract class Enemy{
    protected String name;
    protected double health;
    protected double damagePlacehold;
    protected Weapon enemyWeapon;
    

    public Enemy(String name, double health, double damagePlacehold){
        //setting stats based off of difficulty set by player
        int difficulty = Game.getInstance().getDifficulty();
        this.name = name;
        switch(name){
            case "Drone" -> this.enemyWeapon = WeaponFactory.createWeapon(0);

            case "Soldier" -> this.enemyWeapon = WeaponFactory.createWeapon(1);

            case "Commander" -> this.enemyWeapon = WeaponFactory.createWeapon(2);
        }
        
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
    //inherited attack method abstracted to allow flexibility for the other classes that use it
    public abstract String attack(Player player);

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

