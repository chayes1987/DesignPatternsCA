package strategy;

public class MainCharacter extends Character {

    public MainCharacter(){
        super();
        attackBehaviour = new AttackWithAK47();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
