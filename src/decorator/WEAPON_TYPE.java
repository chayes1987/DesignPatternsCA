package decorator;

public enum WEAPON_TYPE {
    SIMPLE_GUN(0), FLAME_THROWER(1), BAYONET(2), GRENADE_LAUNCHER(3), SNIPER(4), PIMPED_GUN(5);
    private int type;
    WEAPON_TYPE(int type){
        this.type = type;
    }

}
