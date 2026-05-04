public abstract class Weapon{
    protected String weaponType;
    protected int damage;

    public Weapon(String weaponType, int damage){
        this.weaponType = weaponType;
        this.damage = damage;
    }
    public abstract String getWeaponType();
        
}