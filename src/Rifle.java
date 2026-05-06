public class Rifle extends Weapon{
    public Rifle(){
        super("Rifle", 30);
    }
    public String getWeaponType(){
        return weaponType;
    }
    @Override
    public int getDamage(){
        return damage;
    }
    
}