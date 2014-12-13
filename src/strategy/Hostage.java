package strategy;

public class Hostage extends Character {

    public Hostage(){
        super();
        attackBehaviour = new CantAttack();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
