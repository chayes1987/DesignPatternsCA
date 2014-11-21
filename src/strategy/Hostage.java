package strategy;

public class Hostage extends Character {


    @Override
    public String shoot() {
        return "can't shoot...";
    }

    public String throwGrenade(){
        return "can't throw grenade...";
    }
}
