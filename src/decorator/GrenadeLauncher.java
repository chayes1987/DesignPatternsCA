package decorator;

public class GrenadeLauncher extends ModDecorator {

    public GrenadeLauncher(Gun gun) {
        super(gun);
    }

    public String getDescription(){
        return gun.getDescription() + " with added Grenade Launcher";
    }
}
