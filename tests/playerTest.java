import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class playerTest{
    @BeforeEach
    void gameSetUp(){
        Game.getInstance().setDifficulty(2);
    }
    //testing that user initial Stats getter works properly
    @Test
    void testPlayerInitialHealth(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        assertEquals(100, player.getUserHealth());
    }
    @Test
    void testUserNameStored(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        assertEquals("TestUser", player.getUserName());
    }
    @Test
    void testPlayerWeaponTypeIsRetrieved(){
        Player player = new Player("TestUser", 100, 0, new Rifle(), 0);
        assertEquals("Rifle", player.getPlayerWeapon().getWeaponType());
    }
    //testing setters
    @Test
    void testPlayerHealthSetter(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        player.setUserHealth(60);
        assertEquals(60, player.getUserHealth());
    }
    @Test
    void testPlayerScoreSetter(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        player.setPlayerScore(5);
        assertEquals(5, player.getPlayerScore());
    }
    @Test
    void testMaxHealthIsInitialHealth(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        assertEquals(100, player.getMaxHealth());
    }
    @Test
    void testPlayerCoinsUpdate(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        player.setCoinAmount(5);
        assertEquals(5, player.getCoinAmount());
    }
    @Test
    void testInitialPlayerCoins(){
        Player player = new Player("TestUser", 100, 0, new Melee(), 0);
        assertEquals(0, player.getCoinAmount());
    }
}