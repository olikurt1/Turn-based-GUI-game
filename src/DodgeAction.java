public class DodgeAction implements CombatAction{
    public String execute(Player player, Enemy enemy){
        return player.playerDodge(enemy);
    }
}