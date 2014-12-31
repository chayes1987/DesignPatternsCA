package strategy;

import command.ICheatCodeReceiver;

public class Enemy extends Character implements ICheatCodeReceiver {

    public Enemy(String name){
        super(name);
        attackBehaviour = new AttackWithUzi();
        grenadeBehaviour = new CanThrowGrenade();
    }

    @Override
    public String stripWeaponry() {
        return "Enemy has been striped of Weaponry";
    }

    @Override
    public String spontaneouslyCombust() {
        return "Enemy has spontaneously combusted";
    }

    @Override
    public String destroy() {
        return "Enemy has been destroyed";
    }

    @Override
    public String addWeaponry() {
        return "Enemy is re-armed with weaponry";
    }

    @Override
    public String spawn() {
        return "Enemy has re-spawned!";
    }

    @Override
    public String reform() {
        return "Enemy has re-formed";
    }
}
