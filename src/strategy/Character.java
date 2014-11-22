package strategy;

public abstract class Character {
    IShootBehaviour shootBehaviour;
    IGrenadeBehaviour grenadeBehaviour;

    public enum HEALTH_STATE {
        FULL_HEALTH(0), LOW_HEALTH(1), NEARLY_DEAD(2), DEAD(3);
        private int state;
        HEALTH_STATE(int state){
            this.state = state;
        }
    }

    HEALTH_STATE currentState;

    public Character(){
        setCurrentState(HEALTH_STATE.FULL_HEALTH);
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

    public void setCurrentState(HEALTH_STATE state){
        this.currentState = state;
    }

    public HEALTH_STATE getCurrentState(){ return currentState; }

    public void gotShot(String character){
        if (currentState == HEALTH_STATE.FULL_HEALTH){
            this.currentState = HEALTH_STATE.LOW_HEALTH;
            System.out.println(character + " health is now " + this.currentState);
        }else if(currentState == HEALTH_STATE.LOW_HEALTH){
            this.currentState = HEALTH_STATE.NEARLY_DEAD;
            System.out.println(character + " health is now " + this.currentState);
        }else if(currentState == HEALTH_STATE.NEARLY_DEAD) {
            this.currentState = HEALTH_STATE.DEAD;
            System.out.println(character + " is now " + this.currentState);
        }
    }

    public void collectedFirstAidKit(String character){
        if (currentState == HEALTH_STATE.NEARLY_DEAD){
            this.currentState = HEALTH_STATE.LOW_HEALTH;
            System.out.println(character + " health is now " + this.currentState);
        }else if(currentState == HEALTH_STATE.LOW_HEALTH){
            this.currentState = HEALTH_STATE.FULL_HEALTH;
            System.out.println(character + " health is now " + this.currentState);
        }else if(currentState == HEALTH_STATE.FULL_HEALTH){
            this.currentState = HEALTH_STATE.FULL_HEALTH;
            System.out.println(character + " health is already " + this.currentState);
        }
    }
}
