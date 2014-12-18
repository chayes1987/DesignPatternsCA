import composite.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Conor on 17/12/2014.
 */
public class CompositeTest {

    @Test
    public void TestComposite(){
        Level level = new Level("One", "Test", new ArrayList<LevelComponent>());
        Assert.assertEquals("One", level.getLevel());
        Assert.assertEquals("Test", level.getLevelDescription());
        Objective objective1 = new Objective("Kill 5 Enemies");
        Assert.assertEquals("Kill 5 Enemies", objective1.getObjective());
    }
}
