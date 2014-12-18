import factory.IVehicle;
import factory.VehicleFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conor on 18/12/2014.
 */
public class FactoryTest {
    @Test
    public void TestFactory(){
        VehicleFactory enemyVehicleFactory = VehicleFactory.getVehicleFactory("Enemy");
        IVehicle vehicle = enemyVehicleFactory.createVehicle("T");
        Assert.assertNotEquals(null, vehicle);
        vehicle = enemyVehicleFactory.createVehicle("X");
        Assert.assertEquals(null, vehicle);

        VehicleFactory mainCharacterVehicleFactory = VehicleFactory.getVehicleFactory("Main Character");
        vehicle = mainCharacterVehicleFactory.createVehicle("F");
        Assert.assertNotEquals(null, vehicle);
        vehicle = enemyVehicleFactory.createVehicle("X");
        Assert.assertEquals(null, vehicle);
    }
}
