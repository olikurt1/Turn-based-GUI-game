public class AttackAction implements CombatAction{
    public String execute(Player player, Enemy enemy){
        player.playerAttack(enemy);
        return "You attacked the " + enemy.getName() + " with a " +player.getPlayerWeapon().getWeaponType()+"!";
    }
}