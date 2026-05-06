public class Pistol extends Weapon{
    public Pistol(){
        super("Pistol", 15);
    }
    public String getWeaponType(){
        return weaponType;
    }
    @Override
    public int getDamage(){
        return damage;
    }
}