package strategy;

public class MainCharacter extends Character {

    public MainCharacter(){
        shootBehaviour = new ShootWithAK47();
        grenadeBehaviour = new CanThrowGrenade();
    }
}
