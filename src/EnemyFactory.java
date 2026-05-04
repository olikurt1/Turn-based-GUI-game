public class EnemyFactory{
    public static Enemy createEnemy(){
        int randomEnemy = (int)(Math.random()*3);
        switch(randomEnemy){
            case 0 : return new aiDrone();
            case 1 : return new aiSoldier();
            case 2 : return new aiCommander();
            default : throw new IllegalArgumentException("Unknown/invalid enemy:"); 
        }
    }
}