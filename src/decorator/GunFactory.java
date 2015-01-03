package decorator;

public class GunFactory {
    public static Gun createGun(GUN_TYPE type) {
        if(type == GUN_TYPE.SIMPLE_GUN){
            return new SimpleGun();
        }else if(type == GUN_TYPE.SNIPER){
            return new Scope(new SimpleGun());
        }else if(type == GUN_TYPE.GRENADE_LAUNCHER){
            return new GrenadeLauncher(new SimpleGun());
        }else if(type == GUN_TYPE.FLAME_THROWER){
            return new Flamethrower(new SimpleGun());
        }else if(type == GUN_TYPE.BAYONET){
            return new Bayonet(new SimpleGun());
        }else if(type == GUN_TYPE.PIMPED_GUN){
            return new Flamethrower(new Bayonet(new Scope(new GrenadeLauncher(new SimpleGun()))));
        }
        return null;
    }
}
