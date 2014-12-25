package factory;

import command.ICheatCodeReceiver;

public class ArmouredCar extends Vehicle implements ICheatCodeReceiver {

    public ArmouredCar(){
        this.setType("Armoured Vehicle");
    }

    @Override
    public String stripWeaponry() {
        return "Armoured car striped off Weaponry";
    }

    @Override
    public String spontaneouslyCombust() {
        return "Armoured car spontaneously combusted";
    }

    @Override
    public String destroy() {
        return "Armoured car has been destroyed";
    }
}
