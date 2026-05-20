import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class enemyTest{
    @BeforeEach
    void setUp(){
        Game.getInstance().setDifficulty(1);
    }

    @Test
    //test enemy health is correct with difficulty changing
    void testSoldierHealthAtEasyDifficulty(){
        Game.getInstance().setDifficulty(1);
        assertEquals(15.0, new aiSoldier().getEnemyHealth(), 0.001);
    }
    @Test
    //testing that enemy has a weapon equipped
    void testEnemyHasWeaponEquipped(){
        assertNotNull(new aiSoldier().getEnemyWeapon().getWeaponType(), "Enemy should always have weapon assigned");
    }
    @Test
    //test enemy attack doesn't increase player health
    void testEnemyAttackDoesntIncreasePlayerHealth(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        int healthBefore = player.getUserHealth();
        Enemy enemy = EnemyFactory.createEnemy();
        enemy.attack(player);
        assertTrue(player.getUserHealth() <= healthBefore, "Player health should increase after enemy attack call.");
    }
    @Test
    //test enemy factory workss
    void testEnemyFactoryWorks(){
        Enemy enemy = EnemyFactory.createEnemy();
        assertNotNull(enemy.getName(), "Enemy name should not be null");
        assertFalse(enemy.getName().isEmpty(), "Enemy should not be empty");
    }
    @Test
    //test enemy factory returns a correct type
    void testEnemyFactoryReturnsEnemyInstance(){
        assertInstanceOf(Enemy.class, EnemyFactory.createEnemy());
    }
}