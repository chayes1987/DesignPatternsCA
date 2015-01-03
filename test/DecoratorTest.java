import decorator.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Conor on 17/12/2014.
 */
public class DecoratorTest {

    @Test
    public void TestGunDecorator(){
        Gun gun = GunFactory.createGun(GUN_TYPE.SIMPLE_GUN);
        Assert.assertEquals("Gun", gun.getDescription());
        Gun gun1 = GunFactory.createGun(GUN_TYPE.BAYONET);
        Assert.assertEquals("Gun with added Bayonet", gun1.getDescription());
        Assert.assertNotEquals(gun1.getDescription(), gun.getDescription());
        Gun gun2 = GunFactory.createGun(GUN_TYPE.PIMPED_GUN);
        Assert.assertEquals("Gun with added Grenade Launcher with added Scope with added Bayonet with added Flamethrower", gun2.getDescription());
        Assert.assertNotEquals(gun2.getDescription(), gun1.getDescription());
        Gun gun3 = GunFactory.createGun(GUN_TYPE.SNIPER);
        Assert.assertEquals("Gun with added Scope", gun3.getDescription());
        Assert.assertNotEquals(gun3.getDescription(), gun2.getDescription());
    }
}
