public class aiCommander extends Enemy{
    public aiCommander(){
        super("Commander", 60);
    }
    public void attack(){
        System.out.println("Commander attacked you for 30 damage");

    }
}