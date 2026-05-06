public class DodgeAction implements CombatAction{
    public void execute(Player player, Enemy enemy){
        player.playerDodge(enemy);
    }
}