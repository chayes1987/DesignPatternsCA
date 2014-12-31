package strategy;

public class CantThrowGrenade implements IGrenadeBehaviour {
    @Override
    public String throwGrenade() {
        return " can't throw grenade...";
    }
}
