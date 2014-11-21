package strategy;

public class Civilian extends Character{

    public Civilian(){
        shootBehaviour = new CantShoot();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
