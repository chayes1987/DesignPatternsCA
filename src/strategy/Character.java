package strategy;

import state.*;

public abstract class Character {
    String name;
    IAttackBehaviour attackBehaviour;
    IGrenadeBehaviour grenadeBehaviour;

    CharacterHealthState hasArmour, fullHealth,
            lowHealth, nearlyDead, dead, currentState;

    public Character(String name){
        this.name = name;
        hasArmour = new HasArmour(this);
        fullHealth = new FullHealth(this);
        lowHealth = new LowHealth(this);
        nearlyDead = new NearlyDead(this);
        dead = new Dead(this);

        currentState = fullHealth;
    }

    public String walk(){
        return this.getName() + " is walking...";
    }

    public String run(){
        return this.getName() + " is running...";
    }

    public String jump(){
        return this.getName() + " is jumping...";
    }

    public String getName() { return this.name; }

    public String getGrenadeBehaviour(){
        return this.getName() + grenadeBehaviour.throwGrenade();
    }

    public void setGrenadeBehaviour(IGrenadeBehaviour grenadeBehaviour){
        this.grenadeBehaviour = grenadeBehaviour;
    }

    public String getAttackBehaviour(){
        return this.getName() + attackBehaviour.attack();
    }

    public void setAttackBehaviour(IAttackBehaviour attackBehaviour){
        this.attackBehaviour = attackBehaviour;
    }

    public CharacterHealthState getCurrentState(){
        return currentState;
    }

    public void setCurrentState(CharacterHealthState state){
        this.currentState = state;
    }

    public String gotShot(){
        return this.getName() + currentState.gotShot();
    }

    public String collectedFirstAidKit(){
        return this.getName() + currentState.collectedFirstAidKit();
    }

    public String foundArmour(){
        return this.getName() + currentState.foundArmour();
    }

    public CharacterHealthState getHasArmourState() { return hasArmour; }
    public CharacterHealthState getFullHealthState() { return fullHealth; }
    public CharacterHealthState getLowHealthState() { return lowHealth; }
    public CharacterHealthState getNearlyDeadState() { return nearlyDead; }
    public CharacterHealthState getDeadState() { return dead; }
}
