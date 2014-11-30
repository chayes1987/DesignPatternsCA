package factory;

import adapter.HelicopterAdapter;

public class MainCharacterVehicleFactory extends VehicleFactory {

    @Override
    public IVehicle createVehicle(String type) {
        if (type.toLowerCase().equals("f")){
            return new FlameThrowerTank();
        }else if (type.toLowerCase().equals("h")){
            return new HelicopterAdapter(new Helicopter());
        }
        return null;
    }
}
