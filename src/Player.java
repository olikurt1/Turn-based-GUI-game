public class Player{
    private String userName;
    private int userHealth;
    private boolean userLifeStatus;
    private int coins;
    private Weapon playerWeapon;

    public Player(String userName, int userHealth, boolean userLifeStatus, int coins, Weapon playerWeapon){
        this.userName = userName;
        this.userHealth = userHealth;
        this.userLifeStatus = userLifeStatus;
        this.coins = coins;
        this.playerWeapon = playerWeapon;
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
    // status of player alive or not getter and setter
    public boolean getUserLifeStatus(){
        return userLifeStatus;
    }
    public void setUserLifeStatus(boolean userLifeStatus){
        this.userLifeStatus = userLifeStatus;
    }
    //coin getter and setter
    public int getCoinAmount(){
        return coins;
    }
    public void setCointAmount(int coins){
        this.coins = coins;
    }
    //weapon setter getter and if has checker
    public Weapon getPlayerWeapon(){
        return playerWeapon;
    }
    public void setPlayerWeapon(Weapon playerWeapon){
        this.playerWeapon = playerWeapon;
    }
    public boolean hasWeapon(){
        return playerWeapon != null;
    }
}