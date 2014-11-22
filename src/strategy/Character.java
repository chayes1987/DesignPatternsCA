package strategy;

public abstract class Character {
    IShootBehaviour shootBehaviour;
    IGrenadeBehaviour grenadeBehaviour;
    final int FULL_HEALTH = 0;
    final int LOW_HEALTH = 1;
    final int NEARLY_DEAD = 2;
    final int DEAD = 3;
    private int currentState;

    public Character(){
        setCurrentState(FULL_HEALTH);
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

    public String getShootBehaviour(){
        return shootBehaviour.shoot();
    }

    public void setShootBehaviour(IShootBehaviour shootBehaviour){
        this.shootBehaviour = shootBehaviour;
    }

    public void setCurrentState(int state){
        this.currentState = state;
    }

    public int getCurrentState(){ return currentState; }
}
