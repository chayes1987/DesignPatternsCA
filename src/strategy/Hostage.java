package strategy;

public class Hostage extends Character {

    public Hostage(){
        shootBehaviour = new CantShoot();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
