package strategy;

public class MainCharacter extends Character {

    public MainCharacter(){
        super();
        shootBehaviour = new ShootWithAK47();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
