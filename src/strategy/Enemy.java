package strategy;

public class Enemy extends Character{

    public Enemy(){
        super();
        shootBehaviour = new ShootingWithUzi();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
