import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class interactionTest{
    @BeforeEach
    void gameSetUp(){
        Game.getInstance().setDifficulty(1);
    }
    @Test
    void testPlayerAttackNeverIncreasesEnemyHealth(){
        //player can either hit or miss so enemy health decrease or stay the same but shouldn't increase
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        Enemy enemy = EnemyFactory.createEnemy();
        double healthBefore = enemy.getEnemyHealth();
        player.playerAttack(enemy);
        assertTrue(enemy.getEnemyHealth() <= healthBefore, "Enemy health should not increase after player attack");
    }
    @Test
    //checks that player dodge outputs successful dodge or enemy attack output regardless of enemy hit or miss
    void testDodgeReturnsStringWithInfo(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        Enemy enemy = EnemyFactory.createEnemy();
        String msgFromAction = player.playerDodge(enemy);
        assertNotNull(msgFromAction, "Dodge result should not be null");
        assertFalse(msgFromAction.isEmpty(), "Dodge message should not be empty string");
    }
    @Test
    //Player health should not increase during a fight option
    void playerHealthTestAfterFightAction(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        Enemy enemy = EnemyFactory.createEnemy();
        int healthBeforeAction = player.getUserHealth();
        player.playerDodge(enemy);
        player.playerAttack(enemy);
        assertTrue(player.getUserHealth() <= healthBeforeAction, "Player health should not increase after any fight room action");
    }
    @Test
    //test food heal function
    void testFoodHealFuncOnPlayer(){
        Player player = new Player("TestUser", 50, 100, new Melee(), 0);
        new food().heal(player);
        assertEquals(100, player.getUserHealth());
    }
    @Test
    //test food deducts coins from player after heal
    void testFoodHealTakesCoins(){
        Player player = new Player("TestUser", 50, 100, new Melee(), 0);
        new food().heal(player);
        assertEquals(70, player.getCoinAmount());
        }
}
