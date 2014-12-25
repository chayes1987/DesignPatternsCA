package strategy;

import command.ICheatCodeReceiver;

public class Enemy extends Character implements ICheatCodeReceiver {

    public Enemy(){
        super();
        attackBehaviour = new AttackWithUzi();
        grenadeBehaviour = new CanThrowGrenade();
    }

    @Override
    public String stripWeaponry() {
        return "Enemy has been striped off Weaponry";
    }

    @Override
    public String spontaneouslyCombust() {
        return "Enemy has spontaneously combusted";
    }

    @Override
    public String destroy() {
        return "Enemy has been destroyed";
    }
}
