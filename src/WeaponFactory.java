public class WeaponFactory{
    public static Weapon createWeapon(){
        int randomWeapon = (int)(Math.random()*3);
        switch (randomWeapon){
            case 0: return new Melee();
            case 1: return new Pistol();
            case 2: return new Rifle();
            default : throw new IllegalArgumentException("Invalid Weapon");
        }
    }
}