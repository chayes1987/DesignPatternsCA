package factory;

import adapter.IHelicopter;

public class Helicopter extends Vehicle implements IHelicopter{

    public Helicopter(){
        this.setType("Helicopter");
    }

    @Override
    public String fly() {
        return "is flying a " + getType();
    }
}
