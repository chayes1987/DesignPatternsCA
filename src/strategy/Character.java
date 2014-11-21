package strategy;

public abstract class Character {
    IShootBehaviour shootBehaviour;
    IGrenadeBehaviour grenadeBehaviour;

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


}
