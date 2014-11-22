package decorator;

public class Flamethrower extends ModDecorator {

    public Flamethrower(Gun gun) {
        super(gun);
    }

    public String getDescription(){
        return gun.getDescription() + " with added Flamethrower";
    }
}