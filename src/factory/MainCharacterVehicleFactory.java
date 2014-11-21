package factory;

public class MainCharacterVehicleFactory extends VehicleFactory {

    @Override
    public Vehicle createVehicle(String type) {
        if (type.toLowerCase().equals("f")){
            return new FlameThrowerTank();
        }else if (type.toLowerCase().equals("h")){
            return new Helicopter();
        }
        return null;
    }
}
