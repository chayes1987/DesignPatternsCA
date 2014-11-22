package decorator;

public class Scope extends ModDecorator {

    public Scope(Gun gun) {
        super(gun);
    }

    public String getDescription(){
        return gun.getDescription() + " with added Scope";
    }
}