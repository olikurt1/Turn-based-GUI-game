
public class Player{
    private String userName;
    private int userHealth;
    private int coins;
    private Weapon playerWeapon;
    private int Score;
    private int maxHealth;
    private int foodCount;
    private int drinkCount;

    public Player(String userName, int userHealth, int coins, Weapon playerWeapon, int Score){
        this.userName = userName;
        this.userHealth = userHealth;
        this.maxHealth = userHealth;
        this.coins = coins;
        this.playerWeapon = playerWeapon;
        this.Score = Score;
    }
    //userName set and get
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName; 
    }
    //getter and setter of player health
    public int getUserHealth(){
        return userHealth;
    }
    public void setUserHealth(int userHealth){
        this.userHealth = userHealth;
    }
    //coin getter and setter
    public int getCoinAmount(){
        return coins;
    }
    public void setCoinAmount(int coins){
        this.coins = coins;
    }
    //weapon setter getter and if has checker
    public Weapon getPlayerWeapon(){
        return playerWeapon;
    }
    public void setPlayerWeapon(Weapon playerWeapon){
        this.playerWeapon = playerWeapon;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    //functions for player to attack or dodge
    String playerAttack(Enemy e){
        int hitOrMiss = (int)(Math.random()*2);
        switch(hitOrMiss){
            case 0 -> {
                return "You attacked "+e.getName()+" but missed.";
            }
            case 1 -> {
                e.setEnemyHealth(e.getEnemyHealth()-getPlayerWeapon().getDamage()); 
                return "You attacked the " + e.getName() + " with a " +getPlayerWeapon().getWeaponType()+"!";
            }
        }
        return "";
    }
    String playerDodge(Enemy e){
        int dodgeOrNo = (int)(Math.random()*2);
        switch(dodgeOrNo){
            case 0 -> { return "You dodged the attack!"; }
            case 1 -> { return e.attack(this); }
        }
        return "";
    }
    public int getFoodCount(){ 
        return foodCount; 
    }
    public void setFoodCount(int foodCount){ 
        this.foodCount = foodCount; 
    }
    public int getDrinkCount(){ 
        return drinkCount; 
    }
    public void setDrinkCount(int drinkCount){ 
        this.drinkCount = drinkCount; 
    }

    //setter and getter for player score
    public int getPlayerScore(){
        return this.Score;
    }
    public void setPlayerScore(int Score){
        this.Score = Score;
    }
}