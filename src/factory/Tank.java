package factory;

import command.ICheatCodeReceiver;

public class Tank extends Vehicle implements ICheatCodeReceiver {

    public Tank(){
        this.setType("Tank");
    }

    @Override
    public String stripWeaponry() {
        return "Enemy Tank striped off Weaponry";
    }

    @Override
    public String spontaneouslyCombust() {
        return "Enemy Tank spontaneously combusted";
    }

    @Override
    public String destroy() {
        return "Enemy Tank has been destroyed";
    }

    @Override
    public String addWeaponry() {
        return "Tank has re-added weaponry";
    }

    @Override
    public String spawn() {
        return "Tank has re-spawned!";
    }

    @Override
    public String reform() {
        return "Tank has re-formed";
    }
}
