package strategy;

public class Civilian extends Character{

    public Civilian(){
        super();
        shootBehaviour = new CantShoot();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
