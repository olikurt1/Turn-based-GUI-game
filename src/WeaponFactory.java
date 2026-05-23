public class WeaponFactory{
    public static Weapon createWeapon(int n){
        switch (n){
            case 0: return new Melee();
            case 1: return new Pistol();
            case 2: return new Rifle();
            default : throw new IllegalArgumentException("Invalid Weapon");
        }
    }
}