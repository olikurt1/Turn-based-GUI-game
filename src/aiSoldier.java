public class aiSoldier extends Enemy{
    public aiSoldier(){
        super("Soldier", 30, 0);
    }
    public void attack(Player player){
        int chanceOfAttack = (int)(Math.random()*2);

        System.out.println(" /\\ ");
        System.out.println("[::]");
        System.out.println("/||\\");
        System.out.println(" /\\ ");
        switch(chanceOfAttack){
            case 0 -> {
            player.setUserHealth((int)(player.getUserHealth()-damagePlacehold));
            System.out.printf(this.name+" attacked you for %s damage!!!\n", damagePlacehold);
            }
            case 1 -> {
                System.out.println(this.name+" missed, take your chance!!!");
            }
        }

    }
}