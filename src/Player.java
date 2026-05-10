import java.util.Scanner;
public class Player{
    private String userName;
    private int userHealth;
    private boolean userLifeStatus;
    private int coins;
    private Weapon playerWeapon;
    private int Score;

    public Player(String userName, int userHealth, boolean userLifeStatus, int coins, Weapon playerWeapon, int Score){
        this.userName = userName;
        this.userHealth = userHealth;
        this.userLifeStatus = userLifeStatus;
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
    
    void playerChoiceFight(Enemy e, Scanner input){
        System.out.println("Choose action: \n1.Attack\n2.Dodge");
        int fightChoice = input.nextInt();
        input.nextLine();

        //initalise action to null before choice
        CombatAction action = null;
        boolean fightChoiceCheck = false;
        while(fightChoiceCheck == false){
            switch(fightChoice){
                case 1 -> {
                    fightChoiceCheck = true;
                    action = new AttackAction();
                }
                case 2 -> {
                    fightChoiceCheck = true;
                    action = new DodgeAction();
                }
                default -> {
                    if(fightChoice >2 || fightChoice < 1){
                        System.out.println("Choice out of bounds.");
                    }
                }
            }
        }
        //executes action once a correct action has occurred
        if(action != null){
            action.execute(this, e);
        }
    }
    void playerAttack(Enemy e){
        int hitOrMiss = (int)(Math.random()*2);
        switch(hitOrMiss){
            case 0 -> System.out.println("Player missed");
            case 1 -> {
                e.setEnemyHealth(e.getEnemyHealth()-getPlayerWeapon().getDamage());
                System.out.println("You damaged the enemy for "+getPlayerWeapon().getDamage()+" damage!!!");  
            }
        }
    }
    void playerDodge(Enemy e){
        int dodgeOrNo = (int)(Math.random()*2);
        switch(dodgeOrNo){
            case 0 -> System.out.println("You dodged successfully");
            case 1 ->{
                e.attack(this);
            }
        }
    }
    //setter and getter for player score
    public int getPlayerScore(){
        return this.Score;
    }
    public void setPlayerScore(int Score){
        this.Score = Score;
    }
}