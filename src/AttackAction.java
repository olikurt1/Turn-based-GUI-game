public class AttackAction implements CombatAction{
    public void execute(Player player, Enemy enemy){
        player.playerAttack(enemy);
    }
}