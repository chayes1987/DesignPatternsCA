package strategy;

import state.*;

public abstract class Character {
    IAttackBehaviour attackBehaviour;
    IGrenadeBehaviour grenadeBehaviour;

    CharacterHealthState hasArmour, fullHealth,
            lowHealth, nearlyDead, dead, currentState;

    public Character(){
        hasArmour = new HasArmour(this);
        fullHealth = new FullHealth(this);
        lowHealth = new LowHealth(this);
        nearlyDead = new NearlyDead(this);
        dead = new Dead(this);

        currentState = fullHealth;
    }

    public String walk(){
        return "walking...";
    }

    public String run(){
        return "running...";
    }

    public String jump(){
        return "jumping...";
    }

    public String getGrenadeBehaviour(){
        return grenadeBehaviour.throwGrenade();
    }

    public void setGrenadeBehaviour(IGrenadeBehaviour grenadeBehaviour){
        this.grenadeBehaviour = grenadeBehaviour;
    }

    public String getAttackBehaviour(){
        return attackBehaviour.attack();
    }

    public void setAttackBehaviour(IAttackBehaviour attackBehaviour){
        this.attackBehaviour = attackBehaviour;
    }

    public void setCurrentState(CharacterHealthState state){
        this.currentState = state;
    }

    public void gotShot(String character){
        currentState.gotShot(character);
    }

    public void collectedFirstAidKit(String character){
        currentState.collectedFirstAidKit(character);
    }

    public void foundArmour(String character){
        currentState.foundArmour(character);
    }

    public CharacterHealthState getHasArmourState() { return hasArmour; }
    public CharacterHealthState getFullHealthState() { return fullHealth; }
    public CharacterHealthState getLowHealthState() { return lowHealth; }
    public CharacterHealthState getNearlyDeadState() { return nearlyDead; }
    public CharacterHealthState getDeadState() { return dead; }
}
