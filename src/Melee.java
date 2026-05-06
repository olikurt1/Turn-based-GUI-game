public class Melee extends Weapon{
    public Melee(){
        super("Smart Knife", 10);
    }
    public String getWeaponType(){
        return weaponType;
    }
    @Override
    public int getDamage(){
        return damage;
    }
}