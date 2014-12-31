package strategy;

public class MainCharacter extends Character {

    public MainCharacter(String name){
        super(name);
        attackBehaviour = new AttackWithAK47();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
