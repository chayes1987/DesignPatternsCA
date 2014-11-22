package strategy;

public class Hostage extends Character {

    public Hostage(){
        super();
        shootBehaviour = new CantShoot();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
