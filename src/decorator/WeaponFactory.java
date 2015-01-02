package decorator;

public class WeaponFactory {
    public static Gun createWeapon(WEAPON_TYPE type) {
        if(type == WEAPON_TYPE.SIMPLE_GUN){
            return new SimpleGun();
        }else if(type == WEAPON_TYPE.SNIPER){
            return new Scope(new SimpleGun());
        }else if(type == WEAPON_TYPE.GRENADE_LAUNCHER){
            return new GrenadeLauncher(new SimpleGun());
        }else if(type == WEAPON_TYPE.FLAME_THROWER){
            return new Flamethrower(new SimpleGun());
        }else if(type == WEAPON_TYPE.BAYONET){
            return new Bayonet(new SimpleGun());
        }else if(type == WEAPON_TYPE.PIMPED_GUN){
            return new Flamethrower(new Bayonet(new Scope(new GrenadeLauncher(new SimpleGun()))));
        }
        return null;
    }
}
