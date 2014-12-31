package strategy;

public class Hostage extends Character {

    public Hostage(String name){
        super(name);
        attackBehaviour = new CantAttack();
        grenadeBehaviour = new CantThrowGrenade();
    }
}
