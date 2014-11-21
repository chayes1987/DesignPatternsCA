package strategy;

public class Enemy extends Character{

    public Enemy(){
        shootBehaviour = new ShootingWithUzi();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
