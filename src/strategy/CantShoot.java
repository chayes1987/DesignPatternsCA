package strategy;

public class CantShoot implements IShootBehaviour{

    @Override
    public String shoot() {
        return "can't shoot...";
    }
}
