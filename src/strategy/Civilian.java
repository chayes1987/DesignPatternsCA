package strategy;

public class Civilian extends Character{


    @Override
    public String shoot() {
        return "can't shoot...";
    }

    public String throwGrenade(){
        return "can't throw grenade...";
    }
}
