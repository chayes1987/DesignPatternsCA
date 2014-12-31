package strategy;

public class CanThrowGrenade implements IGrenadeBehaviour {

    @Override
    public String throwGrenade() {
        return " is throwing grenade...";
    }
}
