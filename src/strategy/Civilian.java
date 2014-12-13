package strategy;

public class Civilian extends Character{

    public Civilian(){
        super();
        attackBehaviour = new CantAttack();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
