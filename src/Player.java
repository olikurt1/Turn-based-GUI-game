public class Player{
    private String userName;
    private int userHealth;

    public Player(String userName, int userHealth){
        this.userName = userName;
        this.userHealth = userHealth;
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


}