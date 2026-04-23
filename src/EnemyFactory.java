public class EnemyFactory{
    public static Enemy createEnemy(String enemyType){
        switch(enemyType){
            case "Drone" : return new aiDrone();
            case "Soldier" : return new aiSoldier();
            case "Commander": return new aiCommander();
            default: throw new IllegalArgumentException("Unknown/invalid enemy: "+enemyType); 
        }
    }
}