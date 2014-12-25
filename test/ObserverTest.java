import observer.IObserver;
import observer.LocationObserver;
import observer.PlayerLocation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Conor on 25/12/2014.
 */
public class ObserverTest {

    @Test
    public void TestGunDecorator(){
        PlayerLocation mainCharacterLocation = new PlayerLocation(new ArrayList<IObserver>());
        Assert.assertEquals(0, mainCharacterLocation.observerCount());
        LocationObserver mainCharacterLocationObserver = new LocationObserver(mainCharacterLocation);

        Assert.assertNotEquals(0, mainCharacterLocation.observerCount());
        Assert.assertEquals(1, mainCharacterLocation.observerCount());

        mainCharacterLocation.setLongitude(-245.8);
        mainCharacterLocation.setLatitude(124.37);
        Assert.assertEquals("Main Character Position [-245.8, 124.37]", mainCharacterLocationObserver.getLocation());
        Assert.assertNotEquals("Main Character Position [124.37, -245.8]", mainCharacterLocationObserver.getLocation());

        mainCharacterLocation.unregister(mainCharacterLocationObserver);
        Assert.assertNotEquals(1, mainCharacterLocation.observerCount());
        Assert.assertEquals(0, mainCharacterLocation.observerCount());

        mainCharacterLocation.register(mainCharacterLocationObserver);
        Assert.assertNotEquals(0, mainCharacterLocation.observerCount());
        Assert.assertEquals(1, mainCharacterLocation.observerCount());

        LocationObserver differentCharacterObserver = new LocationObserver(mainCharacterLocation);
        Assert.assertNotEquals(1, mainCharacterLocation.observerCount());
        Assert.assertEquals(2, mainCharacterLocation.observerCount());
    }
}
