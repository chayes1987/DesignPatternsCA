package factory;

public abstract class VehicleFactory {

    public abstract IVehicle createVehicle(String type);

    public static VehicleFactory getVehicleFactory(String type){
        if(type.equals("Enemy")){
            return new EnemyVehicleFactory();
        }else if(type.equals("Main Character")){
            return new MainCharacterVehicleFactory();
        }
        return null;
    }
}
