package strategy;

public class Civilian extends Character{

    public Civilian(String name){
        super(name);
        attackBehaviour = new CantAttack();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
