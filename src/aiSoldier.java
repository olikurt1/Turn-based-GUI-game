public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30);
    }
    public void attack(){
        System.out.println("Solider attacked you dealing 15 damage.");
    }
}