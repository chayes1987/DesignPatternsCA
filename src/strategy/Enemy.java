package strategy;

public class Enemy extends Character{

    public Enemy(){
        super();
        attackBehaviour = new AttackWithUzi();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
