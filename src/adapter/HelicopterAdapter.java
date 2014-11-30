package adapter;

import factory.IVehicle;

public class HelicopterAdapter implements IVehicle{
    private IHelicopter iHelicopter;

    public HelicopterAdapter(IHelicopter iHelicopter){
        this.iHelicopter = iHelicopter;
    }

    @Override
    public String drive() {
        return iHelicopter.fly();
    }

    @Override
    public String shoot() {
        return iHelicopter.shoot();
    }
}
