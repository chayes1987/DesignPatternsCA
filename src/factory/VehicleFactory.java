package factory;

public class VehicleFactory {

    public Vehicle createVehicle(String type){
        if (type.toLowerCase().equals("t")){
            return new Tank();
        }else if (type.toLowerCase().equals("a")){
            return new ArmouredCar();
        }
        return null;
    }
}
