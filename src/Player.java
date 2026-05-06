import java.util.Scanner;
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
    void playerChoiceFight(Enemy e){
        Scanner input = new Scanner(System.in);
        System.out.println("Choose action: \n1.Attack\n2.Dodge");
        int fightChoice = input.nextInt();
        input.nextLine();

        //initalise action to null before choice
        CombatAction action = null;
        switch(fightChoice){
            case 1 -> action = new AttackAction();
            case 2 -> action = new DodgeAction();
            default -> System.out.println("Invalid action.");
        }
        //executes action once a correct action has occurred
        if(action != null){
            action.execute(this, e);
        }
        input.close();
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
                setUserHealth(getUserHealth()-e.getEnemyWeapon().getDamage());
                System.out.println("Dodge unsuccessful, Enemy hit you for "+ e.getEnemyWeapon().getDamage()+" damage!!!");
            }
        }
    }
}