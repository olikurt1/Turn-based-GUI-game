//strategy design pattern for letting player choose what to do against enemy
public interface CombatAction{
    String execute(Player player, Enemy enemy);
}