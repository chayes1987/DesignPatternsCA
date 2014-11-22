package decorator;

public abstract class ModDecorator implements Gun{
    protected Gun gun;

    public ModDecorator(Gun gun){
        this.gun = gun;
    }

    public String getDescription(){
        return gun.getDescription();
    }
}
