import adapter.HelicopterAdapter;
import factory.Helicopter;
import factory.IVehicle;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conor on 18/12/2014.
 */
public class AdapterTest {

    @Test
    public void TestAdapter(){
        IVehicle helicopter = new Helicopter();
        Assert.assertEquals("is driving a Helicopter", helicopter.drive());
        Assert.assertEquals("is shooting from Helicopter", helicopter.shoot());
        helicopter = new HelicopterAdapter(new Helicopter());
        Assert.assertEquals("is flying a Helicopter", helicopter.drive());
        Assert.assertEquals("is shooting from Helicopter", helicopter.shoot());
    }
}
