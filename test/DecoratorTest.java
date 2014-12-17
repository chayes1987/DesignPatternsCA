import decorator.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conor on 17/12/2014.
 */
public class DecoratorTest {

    @Test
    public void TestGunDecorator(){
        Gun gun = new SimpleGun();
        Assert.assertEquals("Gun", gun.getDescription());
        Gun gun1 = new Bayonet(gun);
        Assert.assertEquals("Gun with added Bayonet", gun1.getDescription());
        Assert.assertNotEquals(gun1.getDescription(), gun.getDescription());
        Gun gun2 = new Flamethrower(new Bayonet(new Scope(new GrenadeLauncher(gun))));
        Assert.assertEquals("Gun with added Grenade Launcher with added Scope with added Bayonet with added Flamethrower", gun2.getDescription());
        Assert.assertNotEquals(gun2.getDescription(), gun1.getDescription());
        Gun gun3 = new GrenadeLauncher(new Scope(gun));
        Assert.assertEquals("Gun with added Scope with added Grenade Launcher", gun3.getDescription());
        Assert.assertNotEquals(gun3.getDescription(), gun2.getDescription());
    }
}
