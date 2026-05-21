public class AttackAction implements CombatAction{
    public String execute(Player player, Enemy enemy){
        return player.playerAttack(enemy);
    }
}