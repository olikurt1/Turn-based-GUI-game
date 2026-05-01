public class Player{
    private String userName;
    private int userHealth;
    private boolean userLifeStatus;

    public Player(String userName, int userHealth, boolean userLifeStatus){
        this.userName = userName;
        this.userHealth = userHealth;
        this.userLifeStatus = userLifeStatus;
    }
    
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName; 
    }

    public int getUserHealth(){
        return userHealth;
    }
    public void setUserHealth(int userHealth){
        this.userHealth = userHealth;
    }

    public boolean getUserLifeStatus(){
        return userLifeStatus;
    }
    public void setUserLifeStatus(boolean userLifeStatus){
        this.userLifeStatus = userLifeStatus;
    }


}