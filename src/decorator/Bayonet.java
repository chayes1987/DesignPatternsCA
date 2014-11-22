package decorator;

public class Bayonet extends ModDecorator {

    public Bayonet(Gun gun) {
        super(gun);
    }

    public String getDescription(){
        return gun.getDescription() + " with added Bayonet";
    }
}
